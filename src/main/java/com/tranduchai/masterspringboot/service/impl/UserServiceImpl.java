package com.tranduchai.masterspringboot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tranduchai.masterspringboot.dto.record.UserRequestRecord;
import com.tranduchai.masterspringboot.dto.record.UserResponseRecord;
import com.tranduchai.masterspringboot.entity.User;
import com.tranduchai.masterspringboot.mapper.UserMapper;
import com.tranduchai.masterspringboot.repository.UserRepository;
import com.tranduchai.masterspringboot.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

   private final UserRepository userRepository;
   private final UserMapper userMapper;

   @Override
   public void create(UserRequestRecord request) {
      userRepository.save(mapToEntity(request));
   }

   @Override
   public void update(String id, UserRequestRecord request) {
      Optional<User> user = userRepository.findById(id);
      if (user.isEmpty()) {
         throw new IllegalArgumentException("User not exist");
      }
      User userUpdate = user.get();
      userUpdate.setAddress(request.address());
      userUpdate.setEmail(request.email());
      userUpdate.setFullName(request.fullName());
      userUpdate.setPassword(request.password());
      userUpdate.setPhone(request.phone());
      userUpdate.setUserName(request.userName());

      userRepository.save(userUpdate);
   }

   @Override
   public List<UserResponseRecord> index() {
      List<User> list = userRepository.findAll();
      return list.stream().map(this::mapToResponse).toList();
   }

   @Override
   public void delete(String id) {
      Optional<User> user = userRepository.findById(id);
      if (user.isEmpty()) {
         throw new IllegalArgumentException("User not exist");
      }
      userRepository.delete(user.get());
   }

   private User mapToEntity(UserRequestRecord request) {
      return userMapper.toEntity(request);
   }

   // Cách cũ
   // private UserResponse mapToResponse(User user) {
   // return UserResponse.builder().id(user.getId())
   // .fullName(user.getFullName())
   // .address(user.getAddress())
   // .email(user.getEmail())
   // .phone(user.getPhone())
   // .userName(user.getUserName()).build();
   // }

   private UserResponseRecord mapToResponse(User user) {
      return userMapper.toResponse(user);
   }

}
