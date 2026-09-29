package com.tranduchai.masterspringboot.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import com.tranduchai.masterspringboot.dto.record.ProductResponseRecord;
import com.tranduchai.masterspringboot.entity.Product;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {
   ProductResponseRecord toResponse(Product product);

   // @Mapping(target = "id", ignore = true) // Bỏ qua trường id
   // Product toEntity(Product request);
}