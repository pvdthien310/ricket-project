package com.smsservice.api.service;


public interface SmsService {
    String sendSms(String ticketId, String message);
}
