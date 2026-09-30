package com.tranduchai.masterspringboot.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import com.tranduchai.masterspringboot.dto.record.PatientResponseRecord;
import com.tranduchai.masterspringboot.entity.Patient;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PatientMapper {
   PatientResponseRecord toResponse(Patient patient);
}
