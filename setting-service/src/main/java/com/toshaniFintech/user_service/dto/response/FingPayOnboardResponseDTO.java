package com.toshaniFintech.user_service.dto.response;

import lombok.Data;

@Data
public class FingPayOnboardResponseDTO {
    private String id;
    private String fingPayOnboardDate;
    private String  fingPayOnboardApiUserDetails;
    private String  fingPayOnboardsubmerchantid;
    private String  fingPayOnboardOnboardingStatus;
    private String fingPayOnboardAdminApproved;
}
