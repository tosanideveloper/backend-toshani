package com.toshaniFintech.user_service.entity;

import com.toshaniFintech.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "th_user_security")
public class UserSecurity extends BaseEntity {

    @Column(name = "user_id", nullable = false, unique = true)
    private String userId;

    @Column(name = "mpin_hash")
    private String mpinHash;

    @Column(name = "mpin_enabled")
    private Boolean mpinEnabled = false;

    @Column(name = "forgot_mpin_otp", length = 10)
    private String forgotMpinOtp;

    @Column(name = "forgot_mpin_otp_expiry")
    private LocalDateTime forgotMpinOtpExpiry;

    @Column(name = "google_auth_secret")
    private String googleAuthSecret;

    @Column(name = "google_auth_enabled")
    private Boolean googleAuthEnabled = false;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMpinHash() {
        return mpinHash;
    }

    public void setMpinHash(String mpinHash) {
        this.mpinHash = mpinHash;
    }

    public Boolean getMpinEnabled() {
        return mpinEnabled;
    }

    public void setMpinEnabled(Boolean mpinEnabled) {
        this.mpinEnabled = mpinEnabled;
    }

    public String getForgotMpinOtp() {
        return forgotMpinOtp;
    }

    public void setForgotMpinOtp(String forgotMpinOtp) {
        this.forgotMpinOtp = forgotMpinOtp;
    }

    public LocalDateTime getForgotMpinOtpExpiry() {
        return forgotMpinOtpExpiry;
    }

    public void setForgotMpinOtpExpiry(LocalDateTime forgotMpinOtpExpiry) {
        this.forgotMpinOtpExpiry = forgotMpinOtpExpiry;
    }

    public String getGoogleAuthSecret() {
        return googleAuthSecret;
    }

    public void setGoogleAuthSecret(String googleAuthSecret) {
        this.googleAuthSecret = googleAuthSecret;
    }

    public Boolean getGoogleAuthEnabled() {
        return googleAuthEnabled;
    }

    public void setGoogleAuthEnabled(Boolean googleAuthEnabled) {
        this.googleAuthEnabled = googleAuthEnabled;
    }
}
