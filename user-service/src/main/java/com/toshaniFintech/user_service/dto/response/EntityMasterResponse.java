package com.toshaniFintech.user_service.dto.response;

import lombok.Data;

@Data
public class EntityMasterResponse {

    private String entityUuid;
    private String id;

    private String clientUuid;
    private String partnerUuid;
    private String channelUuid;
    private String hirarchyUuid;

    private String parentHierarchy;
    private String hirarchyLevel;
    private String entityName;
    private String parentEntity;
}