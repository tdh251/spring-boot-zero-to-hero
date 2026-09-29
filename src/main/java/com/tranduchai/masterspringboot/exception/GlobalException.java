package com.tranduchai.masterspringboot.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tranduchai.masterspringboot.common.ApiResponse;

@RestControllerAdvice
public class GlobalException {

   @ExceptionHandler(MethodArgumentNotValidException.class)
   public ApiResponse<Map<String, String>> handlerValidatioException(MethodArgumentNotValidException ex) {
      Map<String, String> errors = new HashMap<>();

      ex.getBindingResult().getFieldErrors().forEach(error -> {
         errors.put(error.getField(), error.getDefaultMessage());
      });
      return ApiResponse.errorListDataMessage(55, "Errors", errors);
   }

   @ExceptionHandler(RuntimeException.class)
   public ResponseEntity<ApiResponse<Object>> handlerRuntimeException(RuntimeException ex) {
      ApiResponse<Object> apiResponse = ApiResponse.errorListDataMessage(500, "Errors", null);
      return ResponseEntity.badRequest().body(apiResponse);
   }
}
