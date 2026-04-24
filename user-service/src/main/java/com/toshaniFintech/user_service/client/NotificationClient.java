package com.toshaniFintech.user_service.client;

import com.toshaniFintech.user_service.dto.request.PasswordResetSuccessMailRequest;
import com.toshaniFintech.user_service.dto.request.ResetPasswordMailRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "notification-service", url = "http://localhost:8085")
public interface NotificationClient {

    @PostMapping("/api/v1/notifications/email/reset-password")
    Boolean sendResetPasswordMail(@RequestBody ResetPasswordMailRequest request);

    @PostMapping("/api/v1/notifications/email/reset-success")
    Boolean sendPasswordResetSuccessMail(@RequestBody PasswordResetSuccessMailRequest request);
}
