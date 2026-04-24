package com.toshaniFintech.notification.service;


import com.toshaniFintech.common.dto.request.EmailReq;

public interface EmailService {

    Boolean sendEmail(EmailReq emailReq);

    Boolean sendResetPasswordMail(String toEmail, String userName, String token);

    Boolean sendPasswordResetSuccessMail(String toEmail, String userName);
}
