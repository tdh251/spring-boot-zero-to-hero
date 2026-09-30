package com.tranduchai.masterspringboot.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tranduchai.masterspringboot.dto.record.PatientResponseRecord;
import com.tranduchai.masterspringboot.dto.record.UserResponseRecord;
import com.tranduchai.masterspringboot.entity.Checkup;
import com.tranduchai.masterspringboot.entity.Patient;
import com.tranduchai.masterspringboot.mapper.PatientMapper;
import com.tranduchai.masterspringboot.repository.PatientRepository;
import com.tranduchai.masterspringboot.service.PatientService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

   private final PatientRepository patientRepository;

   @Override
   public List<PatientResponseRecord> index() {
      // List<Patient> list = patientRepository.findAllWithCheckUp();
      List<Patient> list = patientRepository.findAllWithCheckUpoptimized();

      return list.stream().map(p -> {
         List<String> diagnoses = p.getCheckups().stream()
               .map(Checkup::getDiagnosis)
               .toList();
         return new PatientResponseRecord(p.getId(), p.getName(), diagnoses);
      }).toList();
   }

}
