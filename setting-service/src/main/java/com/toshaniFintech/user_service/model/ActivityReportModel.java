package com.toshaniFintech.user_service.model;

import lombok.Data;

@Data
public class ActivityReportModel {
    private String startDate;
    private String endDate;

    private Long pageNo = 0L;
    private Long pageSize = 10L;

    private String search;
    private String searchByField;

    private String id;
    private String apiUserDetail;
    private String date;
    private String updatedBy;
    private String function;
}
