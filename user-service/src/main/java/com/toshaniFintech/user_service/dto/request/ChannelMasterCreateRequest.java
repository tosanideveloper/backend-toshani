package com.toshaniFintech.user_service.dto.request;

import lombok.Data;

@Data
public class ChannelMasterCreateRequest {
    private String channelName;
    private String channelStatus;
}
