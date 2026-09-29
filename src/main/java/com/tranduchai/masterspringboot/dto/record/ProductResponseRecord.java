package com.tranduchai.masterspringboot.dto.record;

import java.math.BigDecimal;

public record ProductResponseRecord(
      Long id,
      String name,
      BigDecimal price,
      String category) {

}
