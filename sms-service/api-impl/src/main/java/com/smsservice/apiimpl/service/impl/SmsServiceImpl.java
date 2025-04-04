package com.smsservice.apiimpl.service.impl;

import com.smsservice.api.service.SmsService;
import org.springframework.stereotype.Service;

@Service
public class SmsServiceImpl implements SmsService {

    @Override
    public String sendSms(String ticketId, String message) {
        return message.concat("Sms sent successfully");
    }
}
