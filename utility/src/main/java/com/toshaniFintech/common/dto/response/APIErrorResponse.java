package com.toshaniFintech.common.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class APIErrorResponse {
    private String errorCode;
    private String errorMessage;
    private List<String> errorMessages;
}
