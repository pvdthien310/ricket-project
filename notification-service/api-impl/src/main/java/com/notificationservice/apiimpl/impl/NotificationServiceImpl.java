package com.notificationservice.apiimpl.impl;

import com.notificationservice.api.service.NotificationService;
import com.orderservice.common.enums.NotificationMethod;
import com.orderservice.common.model.NotificationDTO;
import com.smsservice.api.service.RSocketSmsClientApi;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.text.MessageFormat;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final RSocketSmsClientApi rSocketSmsClientApi;

    private final JavaMailSender emailSender;

    @Override
    public String sendNotification(NotificationDTO notification) {
        if (Objects.isNull(notification)) {
            return "Body is null!";
        }

        if (notification.getMethod().compareTo(NotificationMethod.SMS) == 0) {
            return rSocketSmsClientApi.sendMessage("1234");
        } else {
            try {
                ClassPathResource resource = new ClassPathResource("templates/mail-template.html");
                String htmlContent = new String(Files.readAllBytes(resource.getFile().toPath()), StandardCharsets.UTF_8);
                MimeMessage message = emailSender.createMimeMessage();
                MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
                helper.setFrom("thuckhungfa@gmail.com");
                helper.setTo(notification.getToEmail());
                helper.setSubject(notification.getSubject());
                helper.setText(htmlContent, true);
                emailSender.send(message);
                return MessageFormat.format("Sent mail to {0} with subject: {1} successfully!", notification.getToEmail(), message.getSubject());
            } catch (Exception e) {
                return e.getMessage();
            }
        }
    }
}
