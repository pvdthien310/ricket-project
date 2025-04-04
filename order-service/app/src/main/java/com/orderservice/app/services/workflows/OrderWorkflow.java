package com.orderservice.app.services.workflows;

import com.orderservice.common.model.OrderDTO;
import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface OrderWorkflow {
    @WorkflowMethod
    void createOrder(OrderDTO orderDTO);
}
