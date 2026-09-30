package com.tranduchai.masterspringboot.service.impl;

import java.math.BigDecimal;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.data.web.config.EnableSpringDataWebSupport.PageSerializationMode;
import org.springframework.stereotype.Service;

import com.tranduchai.masterspringboot.dto.record.ProductResponseRecord;
import com.tranduchai.masterspringboot.entity.Product;
import com.tranduchai.masterspringboot.mapper.ProductMapper;
import com.tranduchai.masterspringboot.repository.ProductRepository;
import com.tranduchai.masterspringboot.repository.specification.ProductSpecification;
import com.tranduchai.masterspringboot.service.ProductService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
// Ano -> để chuẩn hóa lại cấu trúc Page sang format DTO chuẩn khi trả về JSON:
@EnableSpringDataWebSupport(pageSerializationMode = PageSerializationMode.VIA_DTO)
public class ProductServiceImpl implements ProductService {

   private final ProductRepository productRepository;
   private final ProductMapper productMapper;

   @Override
   public Page<ProductResponseRecord> getAllProducts(String category, Pageable pageable) {
      // Lấy products có pagination
      // Page<Product> products = productRepository.findAll(pageable);

      // Lấy products có category với custom query
      // Page<Product> products = productRepository.findActiveByCategory(category,
      // pageable);

      // Lấy products với nhiều giá trị filters kết hợp sử dụng JPA Specification
      Page<Product> products = productRepository
            .findAll(ProductSpecification.filterProducts("nokia", BigDecimal.valueOf(3000), category), pageable);
      return products.map(productMapper::toResponse);
   }

}
