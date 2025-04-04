package com.notificationservice.apiimpl.impl;

import com.notificationservice.api.service.RSocketNotificationClientAPI;
import com.orderservice.common.model.NotificationDTO;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class RSocketNotificationClientAPIImpl implements RSocketNotificationClientAPI {

    private final RSocketRequester notificationRSocketRequester;

    @Override
    public void sendNotification(NotificationDTO notification) {
        notificationRSocketRequester.route("send-notification").data(notification).retrieveMono(String.class).block();
    }
}
