package com.toshaniFintech.user_service.dto.response;

import lombok.Data;

@Data
public class HierarchyMasterResponse {

    private String hirarchyUuid;
    private String id;
    private String hirarchyLevel;

    private String clientUuid;
    private String partnerUuid;
    private String channelUuid;

    private String hirarchyName;
    private String parentHierarchy;
    private String hirarchyStatus;
}
