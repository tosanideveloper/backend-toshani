package com.toshaniFintech.user_service.entity;

import com.toshaniFintech.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "th_api_All_Merchant")
@Getter
@Setter
public class ApiAllMerchantEntity extends BaseEntity {

    @Column(name = "merchant")
    private String merchant;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "email")
    private String email;

    @Column(name = "is_Pan_Verified")
    private String isPanVerified;

    @Column(name = "is_Aadhaar_Card_Verified")
    private String isAadhaarCardVerified;

    @Column(name = "is_Aadhaar_No_Verified")
    private String isAadhaarNoVerified;

    @Column(name = "status")
    private String status;
}
