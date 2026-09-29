package com.tranduchai.masterspringboot.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.tranduchai.masterspringboot.dto.record.ProductResponseRecord;

public interface ProductService {
   Page<ProductResponseRecord> getAllProducts(String category, Pageable pageable);

   // void createNewProduct(ProductResponseRecord re)
}
