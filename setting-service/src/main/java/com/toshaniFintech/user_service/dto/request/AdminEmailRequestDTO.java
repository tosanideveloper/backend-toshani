package com.toshaniFintech.user_service.dto.request;

import lombok.Data;

@Data
public class AdminEmailRequestDTO {
    private String id;
    private String emailName;
    private String emailAddress;
    private String emailType;
    private String status;
}
