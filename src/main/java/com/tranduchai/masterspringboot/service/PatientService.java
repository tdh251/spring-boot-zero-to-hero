package com.tranduchai.masterspringboot.service;

import java.util.List;

import com.tranduchai.masterspringboot.dto.record.PatientResponseRecord;

public interface PatientService {
   List<PatientResponseRecord> index();
}
