package com.tranduchai.masterspringboot.anotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

// @Target
// @Retention
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CccdValidator.class)
public @interface Cccd {
   String message() default "Căn cước công dân phải có 12 chữ số";

   Class<?>[] groups() default {};

   Class<? extends Payload>[] payload() default {};
}
