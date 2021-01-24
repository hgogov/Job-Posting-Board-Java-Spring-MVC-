package com.company.jobs.dto;

import com.company.jobs.validation.PasswordMatchesConstraint;
import com.company.jobs.validation.ValidEmail;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@PasswordMatchesConstraint
public class UserDTO extends BaseDTO {

    private static final long serialVersionUID = -475776140616146128L;

    @NotBlank
    @Size(max = 255)
    @ValidEmail
    private String email;

    @NotBlank
    @Size(min = 6, max = 64, message = "Password must be between 6 and 64 characters long.")
    private String password;

    @NotBlank
    @Size(min = 6,max = 64)
    private String matchingPassword;

    private List<Long> roleIds;

    public UserDTO() {
    }

    public UserDTO(String email, String password, List<Long> roleIds) {
        this.email = email;
        this.password = password;
        this.roleIds = roleIds;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Long> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<Long> roleIds) {
        this.roleIds = roleIds;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }
}
