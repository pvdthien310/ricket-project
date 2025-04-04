package com.orderservice.app.temporal;

import com.orderservice.app.services.activities.NotificationActivity;
import com.orderservice.app.services.activities.OrderActivity;
import com.orderservice.app.services.activities.ShipmentActivity;
import com.orderservice.app.services.activities.SmsActivity;
import com.orderservice.app.temporal.syncoders.impl.OrderWorkflowImpl;
import io.temporal.worker.Worker;
import io.temporal.worker.WorkerFactory;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TemporalWorkflowFactory {

    public static final String ORDER_TASK_QUEUE = "order-task-queue";
    private final WorkerFactory workerFactory;
    private final SmsActivity smsActivity;
    private final NotificationActivity notificationActivity;
    private final ShipmentActivity shipmentActivity;
    private final OrderActivity orderActivity;

    @PostConstruct
    public void init() {
        Worker orderWorkflowWorker = workerFactory.newWorker(ORDER_TASK_QUEUE);
        orderWorkflowWorker.registerWorkflowImplementationTypes(OrderWorkflowImpl.class);
        orderWorkflowWorker.registerActivitiesImplementations(
                orderActivity, notificationActivity, shipmentActivity, smsActivity
        );

        workerFactory.start();
    }


}
