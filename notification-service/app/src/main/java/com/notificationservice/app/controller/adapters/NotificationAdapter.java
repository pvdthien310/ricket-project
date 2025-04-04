package com.notificationservice.app.controller.adapters;


import com.orderservice.common.model.NotificationDTO;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;


@Controller
public class NotificationAdapter {

    @MutationMapping
    public String sendNotification(@Argument NotificationDTO notification) {
        return notification.getBody();
    }

    @QueryMapping
    public String getNotification(@Argument NotificationDTO notification) {
        return notification.getBody() + "12";
    }

}
