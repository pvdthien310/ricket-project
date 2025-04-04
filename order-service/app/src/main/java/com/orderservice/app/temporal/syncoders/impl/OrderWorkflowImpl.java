package com.orderservice.app.temporal.syncoders.impl;

import com.orderservice.app.services.activities.NotificationActivity;
import com.orderservice.app.services.activities.OrderActivity;
import com.orderservice.app.services.activities.ShipmentActivity;
import com.orderservice.app.services.activities.SmsActivity;
import com.orderservice.app.services.workflows.OrderWorkflow;
import com.orderservice.common.model.OrderDTO;
import io.temporal.activity.ActivityOptions;
import io.temporal.activity.LocalActivityOptions;
import io.temporal.common.RetryOptions;
import io.temporal.workflow.Workflow;

import java.time.Duration;
import java.util.UUID;

public class OrderWorkflowImpl implements OrderWorkflow {

    private ActivityOptions activityOptions = ActivityOptions.newBuilder()
            .setScheduleToCloseTimeout(Duration.ofMinutes(1))
            .setRetryOptions(
                    RetryOptions.newBuilder()
                            .setMaximumAttempts(1)
                            .setDoNotRetry(
                                    IllegalArgumentException.class.getName(),
                                    IllegalArgumentException.class.getName())
                            .build()
            )
            .build();

    private LocalActivityOptions localActivityOptions = LocalActivityOptions.newBuilder()
            .setScheduleToCloseTimeout(Duration.ofMinutes(1))
            .setRetryOptions(
                    RetryOptions.newBuilder()
                            .setMaximumAttempts(3)
                            .setBackoffCoefficient(3)
                            .setDoNotRetry(
                                    IllegalArgumentException.class.getName(),
                                    IllegalArgumentException.class.getName())
                            .build()
            )
            .build();

    private ShipmentActivity shipmentActivity = Workflow.newActivityStub(ShipmentActivity.class, activityOptions);
    private NotificationActivity notificationActivity = Workflow.newActivityStub(NotificationActivity.class, activityOptions);
    private SmsActivity smsActivity = Workflow.newActivityStub(SmsActivity.class, activityOptions);
    private OrderActivity orderActivity = Workflow.newLocalActivityStub(OrderActivity.class, localActivityOptions);

    @Override
    public void createOrder(OrderDTO orderDTO) {
        UUID orderId = orderActivity.insertOrder(orderDTO);
        orderDTO.setOrderId(orderId);
        shipmentActivity.triggerDelivery(orderDTO);
        notificationActivity.sendNotification(orderDTO);
        smsActivity.sendSms(orderDTO);
    }
}
