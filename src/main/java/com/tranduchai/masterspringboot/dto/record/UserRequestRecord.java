package com.tranduchai.masterspringboot.dto.record;

import com.tranduchai.masterspringboot.anotation.Cccd;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserRequestRecord(
      @NotBlank(message = "Tên không được để trống") String fullName,
      String address,
      @Email @NotBlank(message = "Email không được để trống") String email,
      @Min(value = 0, message = "Số điện thoại không được âm") @Size(min = 10, max = 10, message = "Số điện thoại cần đủ 10 số") String phone,
      String userName,
      String password,
      @Cccd // Anotation custom từ anotation/Cccc.java
      String cccd) {
}
