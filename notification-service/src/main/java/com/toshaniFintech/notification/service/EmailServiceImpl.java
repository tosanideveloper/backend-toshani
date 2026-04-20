package com.toshaniFintech.notification.service;

import com.toshaniFintech.common.dto.request.EmailReq;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private Environment environment;

    @Value("${app.mail.from:noreply@toshani.in}")
    private String fromEmail;

    @Value("${app.mail.reset-password-base-url:https://testapi.toshani.in/reset-password}")
    private String resetPasswordBaseUrl;

    @Override
    public Boolean sendEmail(EmailReq emailReq) {
        try {
            MimeMessage mail = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);

            helper.setFrom(fromEmail);
            helper.setTo(emailReq.getToEmail());
            helper.setSubject(emailReq.getSubject());
            helper.setText(emailReq.getBody(), true);

//            // attachment
//            if (!Objects.isNull(emailReq.getSystemFileIds()) && emailReq.getSystemFileIds().length > 0) {
//                for (String systemFileId : emailReq.getSystemFileIds()) {
//                    // TODO: Fetch actual file data using systemFileId from DB/storage
//                    SystemFiles systemFile = new SystemFiles();
//                    FileSystemResource file = new FileSystemResource(new File(""));
//                    helper.addAttachment(systemFile.getFileOriginalName(), file);
//                }
//            }

            mailSender.send(mail);
            log.info("Mail sent successfully to {}", emailReq.getToEmail());
            return true;

        } catch (Exception e) {
            log.error("Failed to send mail to {}", emailReq.getToEmail(), e);
            throw new RuntimeException("Failed to send mail");
        }
    }

    @Override
    public Boolean sendResetPasswordMail(String toEmail, String userName, String token) {

        String resetLink = resetPasswordBaseUrl + "?token=" + token;

        String subject = "Reset Your Password";

        String body = "<html><body>"
                + "<p>Hello " + userName + ",</p>"
                + "<p>We received a request to reset your password.</p>"
                + "<p>Please use the link below to reset your password:</p>"
                + "<p><a href=\"" + resetLink + "\">Reset Password</a></p>"
                + "<p>This link will expire in 30 minutes.</p>"
                + "<p>If you did not request this, please ignore this email.</p>"
                + "<p>Regards,<br/>Toshani Team</p>"
                + "</body></html>";

        EmailReq emailReq = new EmailReq();
        emailReq.setToEmail(toEmail);
        emailReq.setSubject(subject);
        emailReq.setBody(body);

        return sendEmail(emailReq);
    }

    @Override
    public Boolean sendPasswordResetSuccessMail(String toEmail, String userName) {

        String subject = "Password Reset Successful";

        String body = "<html><body>"
                + "<p>Hello " + userName + ",</p>"
                + "<p>Your password has been successfully reset.</p>"
                + "<p>If you did not perform this action, please contact support immediately.</p>"
                + "<p>Regards,<br/>Toshani Team</p>"
                + "</body></html>";

        EmailReq emailReq = new EmailReq();
        emailReq.setToEmail(toEmail);
        emailReq.setSubject(subject);
        emailReq.setBody(body);

        return sendEmail(emailReq);
    }
}