package com.toshaniFintech.user_service.dto.response;

import lombok.Data;

@Data
public class AuthenticatorInfoResponse {
    private Boolean enabled;
    private Boolean secretPresent;
}
