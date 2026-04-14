package com.toshaniFintech.user_service.entity;

import com.toshaniFintech.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "th_affiliate_user")
public class AffiliateUserEntity extends BaseEntity {
    @Column(name = "serial_no", nullable = false, unique = true)
    private String serialNo;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "mobile_number")
    private String mobileNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "wallet_balance")
    private String walletBalance;

    @Column(name = "status")
    private String status;

    @Column(name = "joined_on")
    private String joinedON;

    @Column(name = "action")
    private String action;

    public AffiliateUserEntity(String joinedON, String serialNo, String name, String mobileNumber, String email, String walletBalance, String status, String wallet_balance, String action) {
        this.joinedON = joinedON;
        this.serialNo = serialNo;
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.walletBalance = walletBalance;
        this.status = status;
        this.action = action;
    }

    public AffiliateUserEntity() {

    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWalletBalance() {
        return walletBalance;
    }

    public void setWalletBalance(String walletBalance) {
        this.walletBalance = walletBalance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getJoinedON() {
        return joinedON;
    }

    public void setJoinedON(String joinedON) {
        this.joinedON = joinedON;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
