package com.kelaskoding.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.kelaskoding.repo.MemberRepo;

import org.springframework.beans.factory.annotation.Autowired;

public class EmailUniqueConstraintValidator implements ConstraintValidator<EmailUniqueConstraint, String>{

    @Autowired
    private MemberRepo repo;

    @Override
    public boolean isValid(String memberEmail, ConstraintValidatorContext context) {
        return !repo.existsMemberByMemberEmail(memberEmail);
    }

}
