package com.orderservice.app.controller.order;

import com.orderservice.app.services.workflows.OrderWorkflow;
import com.orderservice.common.model.OrderDTO;
import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("order")
@RequiredArgsConstructor
public class OrderController {


    private final WorkflowClient workflowClient;

    @PostMapping("/")
    public String createOrder(@RequestBody OrderDTO order) {
        var orderFulfillmentWorkflow =
                workflowClient.newWorkflowStub(
                        OrderWorkflow.class,
                        WorkflowOptions.newBuilder()
                                .setWorkflowId("order-" + order.getOrderId())
                                .setTaskQueue("order-task-queue")
                                .build());
        WorkflowClient.start(orderFulfillmentWorkflow::createOrder, order);
        return "Order created";
    }

}
