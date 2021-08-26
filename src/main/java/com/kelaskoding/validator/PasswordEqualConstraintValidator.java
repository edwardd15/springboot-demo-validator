package com.kelaskoding.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.kelaskoding.dto.MemberRequest;

public class PasswordEqualConstraintValidator implements ConstraintValidator<PasswordEqualConstraint, Object>{

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        MemberRequest memberRequest = (MemberRequest) value;
        return memberRequest.getMemberPassword().equals(memberRequest.getRetypeMemberPassword());
    }
    
}
