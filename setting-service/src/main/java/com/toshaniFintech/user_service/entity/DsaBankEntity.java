package com.toshaniFintech.user_service.entity;

import com.toshaniFintech.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "th_dsa_Bank")
@Getter
@Setter
public class DsaBankEntity extends BaseEntity {

    @Column(name = "dsa_bank_name")
    private String dsaBankName;

    @Column(name = "display_name")
    private String displayName;

    @Column(name = "account_name")
    private String accountName;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "ifsc_code")
    private String ifscCode;

    public DsaBankEntity() {
    }

    public DsaBankEntity(Long id, String dsaBankName, String displayName, String accountName, String accountNumber, String ifscCode) {
        this.dsaBankName = dsaBankName;
        this.displayName = displayName;
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.ifscCode = ifscCode;
    }
}
