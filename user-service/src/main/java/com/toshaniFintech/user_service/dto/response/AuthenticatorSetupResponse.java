package com.toshaniFintech.user_service.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthenticatorSetupResponse {
    private String secret;
    private String otpauthUrl;
    private String qrCodeBase64;
}