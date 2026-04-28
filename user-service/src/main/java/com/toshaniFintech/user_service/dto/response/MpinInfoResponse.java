package com.toshaniFintech.user_service.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MpinInfoResponse {
    private Boolean enabled;
    private Boolean hashPresent;
    private Boolean forgotOtpPresent;
    private LocalDateTime forgotMpinOtpExpiry;
}
