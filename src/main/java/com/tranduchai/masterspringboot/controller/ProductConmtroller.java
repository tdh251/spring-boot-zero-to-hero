package com.tranduchai.masterspringboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tranduchai.masterspringboot.common.ApiResponse;
import com.tranduchai.masterspringboot.dto.record.ProductResponseRecord;
import com.tranduchai.masterspringboot.service.ProductService;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductConmtroller {

   private final ProductService productService;

   @GetMapping
   public ApiResponse<Page<ProductResponseRecord>> index(
         // Lấy dữ liệu sau ? ví dụ: .../?page=10 => page = 10, có thể set defaultValue
         @RequestParam(value = "page", defaultValue = "1") int page,
         @RequestParam(value = "size", defaultValue = "9") int size,
         @RequestParam(value = "sort_by", defaultValue = "id") String sortBy,
         @RequestParam(value = "sort_type", defaultValue = "asc") String sortType,
         @RequestParam(defaultValue = "") String category) {
      Sort sort = sortType.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
            : Sort.by(sortBy).descending();
      Pageable pageable = PageRequest.of(page, size, sort);
      return ApiResponse.success(productService.getAllProducts(category, pageable));
   }

}
