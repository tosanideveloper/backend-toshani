package com.toshaniFintech.user_service.dto.response;

import lombok.Data;

@Data
public class DsaBankResponseDTO {
    private String dsaBankName;
    private String displayName;
    private String accountName;
    private String accountNumber;
    private String ifscCode;
}
