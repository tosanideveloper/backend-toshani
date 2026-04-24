package com.toshaniFintech.user_service.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SecurityStatusResponse {
    private Boolean mpinEnabled;
    private Boolean mPinStatus;
    private Boolean authenticatorEnabled;
    private String authenticationCurrentStatus;
}