package com.tranduchai.masterspringboot.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_patients")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Patient {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;
   private String name;

   @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
   private List<Checkup> checkups = new ArrayList<>();
   // private
}
