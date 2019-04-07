package com.onebookshop.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;

public class NumberOnlyValidator implements ConstraintValidator<NumberOnly, String> {

    @Override
    public boolean isValid(String number, ConstraintValidatorContext ctx) {
        String regex = "\\d+";

        if (StringUtils.isNotBlank(number) && StringUtils.isNotEmpty(number)) {
            if (number.matches(regex))
                return true;

            else
                return false;
        }

        return true;
    }


}
