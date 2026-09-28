// package com.tranduchai.masterspringboot.config;

// import org.modelmapper.ModelMapper;
// import org.modelmapper.convention.MatchingStrategies;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// import com.tranduchai.masterspringboot.dto.response.UserResponse;
// import com.tranduchai.masterspringboot.entity.User;

// @Configuration
// public class Config {
// @Bean
// public ModelMapper modelMapper() {
// ModelMapper modelMapper = new ModelMapper();

// modelMapper.getConfiguration()
// .setFieldMatchingEnabled(true)
// .setMatchingStrategy(MatchingStrategies.STRICT);

// modelMapper.typeMap(User.class, UserResponse.class).addMappings(mapper -> {
// mapper.map(User::getUserName, UserResponse::setFullName);
// });

// return modelMapper;
// }
// }

// Đây là cách cũ không tối ưu vì khi run chương trình sẽ tạo ra rất nhiều ....
// làm chương trình bị chậm thay vào đó sử dụng UserMapper
