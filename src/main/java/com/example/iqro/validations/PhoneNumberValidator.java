package com.example.iqro.validations;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class PhoneNumberValidator implements ConstraintValidator<PhoneNumberValid, String> {
    String pattern = "^\\+?\\d{1,3}[-.\\s]?\\(?" +
            "\\d{1,3}\\)?[-.\\s]?\\d{1,4}[-.\\s]?\\d{1,4}[-.\\s]?\\d{1,9}$";

    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext constraintValidatorContext) {
        return phoneNumber.length() == 13 && phoneNumber.startsWith("+996") && phoneNumber.matches(pattern);
    }
}
