package com.tranduchai.masterspringboot.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import com.tranduchai.masterspringboot.dto.record.UserRequestRecord;
import com.tranduchai.masterspringboot.dto.record.UserResponseRecord;
import com.tranduchai.masterspringboot.entity.User;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
   UserResponseRecord toResponse(User user);

   @Mapping(target = "id", ignore = true) // Bỏ qua trường id
   // @Mapping(source = "fullName", target = "fullName") chỉ cần mapping khi trường
   // khai báo ở entity != request hoặc nếu cần format, convert. Ví dụ: Request là
   // fullName, nhưng Entity lại đặt là name $\rightarrow$ Cần @Mapping(source =
   // "fullName", target = "name").
   User toEntity(UserRequestRecord request);
}
