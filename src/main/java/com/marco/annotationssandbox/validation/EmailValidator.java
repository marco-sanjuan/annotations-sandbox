package com.marco.annotationssandbox.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<Email, String> {

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        if(email == null || email.isBlank()){
            return false;
        }
        //simple check, no matter
        return email.contains("@");
    }
}
