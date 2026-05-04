package com.toshaniFintech.user_service.dto.response;

import lombok.Data;

@Data
public class EnquiryFormLogResponse {
    private String id;
    private String enquiryDate;
    private String name;
    private String mobileNumber;
    private String emailId;
    private String companyName;
}
