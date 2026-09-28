package com.tranduchai.masterspringboot.dto.record;

public record UserResponseRecord(
      String id,
      String fullName,
      String address,
      String email,
      String phone,
      String userName) {

}
