package com.tranduchai.masterspringboot.repository.specification;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.tranduchai.masterspringboot.entity.Product;

import jakarta.persistence.criteria.Predicate;

public class ProductSpecification {
   public static Specification<Product> filterProducts(String name, BigDecimal price, String category) {
      // root(Root) địa điện cho products table trong db. Dùng để trỏ tới các cột vd:
      // root.get("price")
      // query(CriteriaQuery) đại diện tổng thể cho câu lệnh query ( SELECT, FROM,
      // WHERE, GROUP BY )
      // criteriaBuilder(CriateriaBuilder) tạo ra các phép toán trong mđ WHERE như >,
      // <, LIKE...
      return ((root, query, criteriaBuilder) -> {
         // price >= 100 là 1 Predicate, name LIKE '%oppo%' là 1 Predicate
         List<Predicate> predicates = new ArrayList<>();

         if (StringUtils.hasText(name)) {
            // Lấy products có tên like name
            predicates
                  .add(criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + name.toLowerCase() + "%"));
         }

         if (price != null) {
            // lấy products có giá >= price
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("price"), price));
         }

         // Kết hợp tất cả điều kiện với toán tử "and".
         // Convert List => Array .toArray(new Predicate[0]) vì criteriaBuilder.and cần
         // truyền vào là 1 []
         return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
      });
   }
}
