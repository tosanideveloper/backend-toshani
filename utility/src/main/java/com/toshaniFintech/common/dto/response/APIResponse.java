package com.toshaniFintech.common.dto.response;

import lombok.Data;

@Data
public class APIResponse<T> {
//    private String statusCode;
    private String message;
    private T data;
}