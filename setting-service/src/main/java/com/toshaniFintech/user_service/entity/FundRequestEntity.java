package com.toshaniFintech.user_service.entity;

import com.toshaniFintech.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "th_fund_request")
public class FundRequestEntity extends BaseEntity {
    @Column(name = "request_id", nullable = false)
    private String requestId;

    @Column(name = "partner_id", nullable = false)
    private String partnerId;

    @Column(name = "company_name", nullable = false)
    private String companyName;

    @Column(name = "bank_name", nullable = false)
    private String bankName;

    @Column(name = "account_no", nullable = false)
    private String accountNo;

    @Column(name = "ifsc_code", nullable = false)
    private String ifscCode;

    @Column(name = "image")
    private String image;

    @Column(name = "status")
    private String status;
    public FundRequestEntity() {
    }
    public FundRequestEntity(Long Id, String requestId, String partnerId, String companyName, String bankName, String accountNo,
                             String ifscCode, String image, String status){
        this.requestId = requestId;
        this.partnerId = partnerId;
        this.companyName = companyName;
        this.bankName = bankName;
        this.accountNo = accountNo;
        this.ifscCode = ifscCode;
        this.image = image;
        this.status = status;

    }
}
