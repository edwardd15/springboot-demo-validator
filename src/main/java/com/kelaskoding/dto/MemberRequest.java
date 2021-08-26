package com.kelaskoding.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.kelaskoding.validator.EmailUniqueConstraint;
import com.kelaskoding.validator.NumberUniqueConstraint;
import com.kelaskoding.validator.PasswordEqualConstraint;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@PasswordEqualConstraint(message = "Retype Password is not same")
public class MemberRequest {
    
    @NotEmpty(message = "Number is required")
    @Size(min = 3, max =5, message="Number length must be in 3 to 5 characters")
    @Pattern(regexp = "MB[0-9]+", message = "Number must be started with \'MB\'")
    @NumberUniqueConstraint(message = "Number is already used")
    private String memberNumber;

    @NotEmpty(message = "Name is required")
    private String memberName;

    @NotEmpty(message = "Email is required")
    @Email(message="Invalid email address")
    @EmailUniqueConstraint(message = "Email is already in use")
    private String memberEmail;

    @NotEmpty(message = "Password is required")
    private String memberPassword;

    @NotEmpty(message = "Retype-password is required")
    private String retypeMemberPassword;
}
