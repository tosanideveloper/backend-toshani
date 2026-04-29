package com.toshaniFintech.user_service.dto.response;

import lombok.Data;

@Data
public class PartnerMasterResponse {

    private String partnerUuid;
    private String id;
    private String clientUuid;   // from relation
    private String partnerName;
    private String partnerBusinessName;
    private String partnerType;
    private String partnerStatus;
}
