package com.tranduchai.masterspringboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tranduchai.masterspringboot.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

   @Query("SELECT p FROM Patient p JOIN FETCH p.checkups")
   List<Patient> findAllWithCheckUp();

   @EntityGraph(attributePaths = { "checkups" })
   @Query("SELECT p FROM Patient p")
   List<Patient> findAllWithCheckUpoptimized();
}
