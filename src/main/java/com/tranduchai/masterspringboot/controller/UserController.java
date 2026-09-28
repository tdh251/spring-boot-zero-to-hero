package com.tranduchai.masterspringboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tranduchai.masterspringboot.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import com.tranduchai.masterspringboot.dto.record.UserRequestRecord;
import com.tranduchai.masterspringboot.dto.record.UserResponseRecord;

@RestController
@RequestMapping(value = "/api/v1/users")
@RequiredArgsConstructor
public class UserController {

   private final UserService userService;

   @GetMapping
   public ResponseEntity<List<UserResponseRecord>> showListUser() {
      return new ResponseEntity<>(userService.index(), HttpStatus.OK);
   }

   @PostMapping
   public ResponseEntity<String> createNewUser(@Valid @RequestBody UserRequestRecord userRequest) {
      userService.create(userRequest);
      return new ResponseEntity<>("Create a new user sussessfully", HttpStatus.CREATED);
   }

   @PutMapping("/{id}")
   public ResponseEntity<String> updateUser(@PathVariable("id") String id,
         @Valid @RequestBody UserRequestRecord userRequest) {
      userService.update(id, userRequest);
      return new ResponseEntity<>("Update a user successfully", HttpStatus.OK);
   }

   @DeleteMapping("/{id}")
   public ResponseEntity<String> deleteUser(@PathVariable("id") String id) {
      userService.delete(id);
      return new ResponseEntity<>("Delete a user successfully", HttpStatus.OK);
   }
}
