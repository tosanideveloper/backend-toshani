package com.toshaniFintech.user_service.dto.response;

import lombok.Data;

@Data
public class ManageSettlementResponseDTO {
    private String id;
    private String day;
    private String startTime;
    private Boolean endTime;
}

