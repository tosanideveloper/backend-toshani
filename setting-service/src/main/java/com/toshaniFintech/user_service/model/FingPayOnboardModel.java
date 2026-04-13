package com.toshaniFintech.user_service.model;

import lombok.Data;

@Data
public class FingPayOnboardModel {
    private String id;
    private String fingPayOnboardDate;
    private String  fingPayOnboardApiUserDetails;
    private String  fingPayOnboardsubmerchantid;
    private String  fingPayOnboardOnboardingStatus;
    private String fingPayOnboardAdminApproved;
}
