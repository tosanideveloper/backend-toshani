package com.toshaniFintech.user_service.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import com.toshaniFintech.user_service.util.AuthConstants;

import java.util.List;

public class UsersRequest {

    @NotBlank(message = AuthConstants.MANDATORY)
    private String userName;

    @NotBlank(message = AuthConstants.MANDATORY)
    private String mobile;

    @NotBlank(message = AuthConstants.MANDATORY)
    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotBlank(message = AuthConstants.MANDATORY)
    private String password;

    @NotNull(message = AuthConstants.MANDATORY)
    private List<String> roles;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}