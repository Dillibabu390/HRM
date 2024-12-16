package com.demo.authserver.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class RoleValidator implements ConstraintValidator<ValidateRole, String> {

    @Override
    public boolean isValid(String role, ConstraintValidatorContext constraintValidatorContext) {
        List<String> roles = List.of(
                "ROLE_EMP",
                "ROLE_ADMIN"
        );
        return roles.contains(role);
    }

}
