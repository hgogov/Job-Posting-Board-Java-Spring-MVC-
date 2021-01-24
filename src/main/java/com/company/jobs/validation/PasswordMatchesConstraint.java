package com.company.jobs.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Documented;

@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MatchingPasswordValidator.class)
@Documented
public @interface PasswordMatchesConstraint {

    String message() default "Passwords do not match.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
