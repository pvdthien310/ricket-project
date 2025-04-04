package com.smsservice.app.controller.message;

import com.smsservice.api.service.SmsService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class SmsMessaging {

    private final SmsService smsService;

    @MessageMapping("sms")
    public String sendMessage(String ticketId) {
        return smsService.sendSms(ticketId, "abc");
    }
}
