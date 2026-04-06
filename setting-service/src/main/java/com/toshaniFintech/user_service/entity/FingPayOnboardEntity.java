package com.toshaniFintech.user_service.entity;

import com.toshaniFintech.user_service.entity.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "TH_FINGPAYONBOARD_USER")
@Getter
@Setter

public class FingPayOnboardEntity extends BaseEntity {
    @Column(name = "fingPayOnboard_date")
    private String fingPayOnboardDate;

    @Column (name = "fingPayOnboard_api_user_details")
    private String fingPayOnboardApiUserDetails;

    @Column (name = "fingPayOnboard_sub_merchant_id")
    private String fingPayOnboardsubmerchantid;

    @Column (name = "fingPayOnboard_onboarding_status")
    private String fingPayOnboardOnboardingStatus;

    @Column (name = "fingPayOnboard_admin_approved")
    private String fingPayOnboardAdminApproved;
}

