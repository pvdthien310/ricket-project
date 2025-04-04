package com.orderservice.common.model;

import com.orderservice.common.enums.NotificationMethod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationDTO {
    private String toEmail;
    private String subject;
    private String body;
    private NotificationMethod method;
}
