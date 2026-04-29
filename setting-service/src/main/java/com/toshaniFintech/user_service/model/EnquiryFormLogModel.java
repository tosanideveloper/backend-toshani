package com.toshaniFintech.user_service.model;

import lombok.Data;

@Data
public class EnquiryFormLogModel {
    private String startDate;
    private String endDate;

    private Long pageNo = 0L;
    private Long pageSize = 10L;

    private String search;
    private String searchByField;

    private String Id;
    private String enquiryDate;
    private String name;
    private String mobileNumber;
    private String emailId;
    private String companyName;
}
