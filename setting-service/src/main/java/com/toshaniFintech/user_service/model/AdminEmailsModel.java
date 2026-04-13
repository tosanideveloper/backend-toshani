package com.toshaniFintech.user_service.model;

import lombok.Data;

@Data
public class AdminEmailsModel {
    private String id;
    private String emailName;
    private String emailAddress;
    private String emailType;
    private String status;
}
