package com.tranduchai.masterspringboot.anotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CccdValidator implements ConstraintValidator<Cccd, String> {

   @Override
   public boolean isValid(String value, ConstraintValidatorContext context) {
      if (value == null || value.isBlank()) {
         return true;
      }
      boolean isMatched = value.matches("[0-9]{12}$");
      return isMatched;
   }

}
