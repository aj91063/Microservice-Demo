package com.micro.orderService.controller;

import com.micro.baseDomains.dto.Order;
import com.micro.baseDomains.dto.OrderEvent;
import com.micro.orderService.kafka.OrderProducerKafka;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("api/event")
public class OrderController {

    @Autowired
    private OrderProducerKafka orderProducerKafka;
    @PostMapping("/order")
    public String placeOrder(@RequestBody Order order){
        order.setOrderId(UUID.randomUUID().toString());
        OrderEvent orderEvent = new OrderEvent();
        orderEvent.setStatus("Pending");
        orderEvent.setMessage("Your order is placed.");
        orderEvent.setOrder(order);
        orderProducerKafka.sendMessage(orderEvent);
        return "Order placed successfully .....";
    }
}
