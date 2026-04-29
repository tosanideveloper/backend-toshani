package com.toshaniFintech.user_service.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class ClientMasterResponse {

    private String clientUuid;
    private String id;
    private String clientId;
    private String clientSecretKey;
    private String clientStatus;
    private String clientName;
}