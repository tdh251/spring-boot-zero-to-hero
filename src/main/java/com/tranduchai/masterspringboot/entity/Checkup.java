package com.tranduchai.masterspringboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tbl_checkups")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Checkup {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;
   private String diagnosis;

   @ManyToOne(fetch = FetchType.LAZY) // Khi dùng FetchType.LAZY thì hibernate không thực thi câu lệnh join lấy dữ
                                      // liệu ngay lập tức thay vào đó sd kỹ thuật Hibernate Proxy
   @JoinColumn(name = "patient_id")
   private Patient patient;

}
