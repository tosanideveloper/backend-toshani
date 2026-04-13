package com.toshaniFintech.user_service.model;

import lombok.Data;

@Data
public class ManageSettlementModel {
    private Long id;
    private String day;
    private String startTime;
    private Boolean endTime;
}
