package com.company.jobs.validation;

import com.company.jobs.dto.UserDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MatchingPasswordValidator implements ConstraintValidator<PasswordMatchesConstraint, Object> {

    @Override
    public void initialize(PasswordMatchesConstraint constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        UserDTO user = (UserDTO) value;
        boolean isValid = user.getPassword().equals(user.getMatchingPassword());
        if(!isValid){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
                    .addPropertyNode( "matchingPassword" ).addConstraintViolation();
        }
        return isValid;
    }
}
