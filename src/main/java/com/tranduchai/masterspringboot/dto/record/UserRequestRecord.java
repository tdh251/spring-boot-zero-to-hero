package com.tranduchai.masterspringboot.dto.record;

public record UserRequestRecord(
      String fullName,
      String address,
      String email,
      String phone,
      String userName,
      String password) {
}
