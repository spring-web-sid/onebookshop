package com.onebookshop.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 Custom validation constraint to validate number only input is given
 */
@Documented
@Constraint(validatedBy=NumberOnlyValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NumberOnly {

    String message() default "{NumberOnly}";
    
    Class<?>[] groups() default {};
     
    Class<? extends Payload>[] payload() default {};
    
}
