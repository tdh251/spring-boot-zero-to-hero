package com.tranduchai.masterspringboot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tbl_user")
@Getter
@Setter
@NoArgsConstructor // Tạo contructor {}
@AllArgsConstructor // Tạo contructor với đầy đủ tham số
@Builder //
public class User {
   @Id
   @GeneratedValue(strategy = GenerationType.UUID)
   private String id;
   private String fullName;
   private String address;
   @Column(unique = true)
   private String email;
   @Column(length = 10)
   private String phone;
   private String userName;
   private String password;

}
