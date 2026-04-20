package com.toshaniFintech.user_service.service.impl;

import com.toshaniFintech.user_service.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${app.mail.from}")
    private String fromEmail;

    @Value("${app.mail.reset-password-base-url}")
    private String resetPasswordBaseUrl;

    public EmailServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void sendResetPasswordMail(String toEmail, String userName, String token) {
        String resetLink = resetPasswordBaseUrl + "?token=" + token;

        String subject = "Reset Your Password";
        String body = "Hello " + userName + ",\n\n"
                + "We received a request to reset your password.\n"
                + "Please use the link below to reset your password:\n\n"
                + resetLink + "\n\n"
                + "This link will expire in 30 minutes.\n\n"
                + "If you did not request this, please ignore this email.\n\n"
                + "Regards,\n"
                + "Toshani Team";

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromEmail);
        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText(body);

        mailSender.send(message);

        log.info("Reset password mail sent successfully to {}", toEmail);
    }

    @Override
    public void sendPasswordResetSuccessMail(String toEmail, String userName) {

        String subject = "Password Reset Successful";

        String body = "Hello " + userName + ",\n\n"
                + "Your password has been successfully reset.\n\n"
                + "If you did not perform this action, please contact support immediately.\n\n"
                + "Regards,\n"
                + "Toshani Team";

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromEmail);
        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText(body);

        mailSender.send(message);
    }
}