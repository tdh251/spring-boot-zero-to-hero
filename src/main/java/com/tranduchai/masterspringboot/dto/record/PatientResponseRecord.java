package com.tranduchai.masterspringboot.dto.record;

import java.util.List;

public record PatientResponseRecord(
      long id,
      String name,
      List<String> diagnoses) {

}
