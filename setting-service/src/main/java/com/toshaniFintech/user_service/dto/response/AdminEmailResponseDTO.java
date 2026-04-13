package com.toshaniFintech.user_service.dto.response;

import lombok.Data;

@Data
public class AdminEmailResponseDTO {
    private String id;
    private String emailName;
    private String emailAddress;
    private String emailType;
    private String status;
}
