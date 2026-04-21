package com.ra.ptit_cntt2_it210_ss12_btth;

import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Constraint(validatedBy = PatientCodeValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface PatientCode {
    String message() default "Mã bệnh nhân phải bắt đầu bằng BN-";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}


class PatientCodeValidator implements ConstraintValidator<PatientCode, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && value.startsWith("BN-");
    }
}