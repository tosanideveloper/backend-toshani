package com.toshaniFintech.user_service.util;

import com.toshaniFintech.user_service.dto.response.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtil {
    public static <T> ResponseEntity<APIResponse<T>> success(String message, T data, HttpStatus status) {
        APIResponse<T> response = new APIResponse<>();
        response.setMessage(message);
        response.setData(data);
        return new ResponseEntity<>(response, status);
    }
}
