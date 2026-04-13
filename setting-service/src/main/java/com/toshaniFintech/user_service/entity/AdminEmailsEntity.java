package com.toshaniFintech.user_service.entity;

import com.toshaniFintech.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "th_admin_emails")
@Getter
@Setter
public class AdminEmailsEntity extends BaseEntity {
    @Column(name="email_name")
    private String emailName;

    @Column(name="email_address")
    private String emailAddress;

    @Column(name="email_type")
    private String emailType;

    @Column(name="status")
    private String status;

    public AdminEmailsEntity(String emailName, String emailAddress, String emailType, String status) {
        this.emailName = emailName;
        this.emailAddress = emailAddress;
        this.emailType = emailType;
        this.status = status;
    }

    public AdminEmailsEntity() {

    }

    public String getEmailName() {
        return emailName;
    }

    public void setEmailName(String emailName) {
        this.emailName = emailName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getEmailType() {
        return emailType;
    }

    public void setEmailType(String emailType) {
        this.emailType = emailType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
