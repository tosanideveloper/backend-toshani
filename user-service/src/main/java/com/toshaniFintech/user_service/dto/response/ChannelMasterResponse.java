package com.toshaniFintech.user_service.dto.response;

import lombok.Data;

@Data
public class ChannelMasterResponse {
    private String channelUuid;
    private String clientUuid;
    private String partnerUuid;
    private String id;
    private String channelName;
    private String channelStatus;
}
