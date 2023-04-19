package com.microservicedemo.OrderService.service;

import com.microservicedemo.OrderService.entity.Order;
import com.microservicedemo.OrderService.model.OrderRequest;
import com.microservicedemo.OrderService.repository.OrderRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Log4j2
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Long placeOrder(OrderRequest orderRequest) {
        Order order = Order
                .builder()
                .productId(orderRequest.getProductId())
                .orderDate(Instant.now())
                .orderStatus("CREATED")
                .amount(orderRequest.getTotalAmount())
                .quantity(orderRequest.getQuantity())
                .build();

        orderRepository.save(order);

        log.info("order id",order.getId());

        return order.getId();
    }
}