package com.tranduchai.masterspringboot.controller;

import org.springframework.web.bind.annotation.RestController;

import com.tranduchai.masterspringboot.common.ApiResponse;
import com.tranduchai.masterspringboot.common.BaseController;
import com.tranduchai.masterspringboot.dto.record.PatientResponseRecord;
import com.tranduchai.masterspringboot.service.PatientService;

import lombok.RequiredArgsConstructor;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping(value = "/api/v1/patients")
@RequiredArgsConstructor
public class PatientController extends BaseController {

   private final PatientService patientService;

   @GetMapping
   public ApiResponse<List<PatientResponseRecord>> showAllPatients() {
      return createSuccessResponse(patientService.index());
   }
}
