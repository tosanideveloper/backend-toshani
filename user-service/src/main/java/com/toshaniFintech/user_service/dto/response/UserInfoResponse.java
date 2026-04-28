package com.toshaniFintech.user_service.dto.response;

import lombok.Data;

@Data
public class UserInfoResponse {
    private UserBasicInfoResponse user;
    private MpinInfoResponse mpin;
    private AuthenticatorInfoResponse authenticator;
}