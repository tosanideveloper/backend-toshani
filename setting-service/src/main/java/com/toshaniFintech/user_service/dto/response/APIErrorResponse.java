package com.toshaniFintech.user_service.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class APIErrorResponse {
    private String errorCode;
    private String errorMessage;
    private List<String> errorMessages;
}
