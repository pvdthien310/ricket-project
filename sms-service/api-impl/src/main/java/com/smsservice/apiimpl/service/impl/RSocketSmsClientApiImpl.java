package com.smsservice.apiimpl.service.impl;

import com.smsservice.api.service.RSocketSmsClientApi;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RSocketSmsClientApiImpl implements RSocketSmsClientApi {

    private final RSocketRequester smsSocketRequester;

    @Override
    public String sendMessage(String ticketId) {
        return smsSocketRequester.route("sms").data(ticketId)
                .retrieveMono(String.class).block();
    }
}
