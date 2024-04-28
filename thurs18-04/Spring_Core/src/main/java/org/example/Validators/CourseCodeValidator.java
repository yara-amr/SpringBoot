package org.example.Validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeValidator implements ConstraintValidator<CourseCode,String> {

    private String prefix;

    @Override
    public void initialize(CourseCode courseCode) {
        this.prefix=courseCode.value();
    }

    @Override
    public boolean isValid(String enteredValue, ConstraintValidatorContext constraintValidatorContext) {
        if(enteredValue!= null && enteredValue.startsWith(prefix)) return true;
        else return false;
    }
}
