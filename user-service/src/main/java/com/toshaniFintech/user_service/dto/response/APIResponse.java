package com.toshaniFintech.user_service.dto.response;

import lombok.Data;

@Data
public class APIResponse<T> {
//    private String statusCode;
    private String message;
    private T data;
}