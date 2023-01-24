package com.orgofarmsgroup.controller;

import com.google.gson.Gson;
import com.orgofarmsgroup.entity.OrderEntity;
import com.orgofarmsgroup.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class OrderGraphQLController {
    private final Gson jsonHelper;
    private final OrderRepository orderRepository;

    @QueryMapping(name = "orders")
    public List<OrderEntity> orders() {
        log.info("OrderGraphQLController.orders");
        return orderRepository.findAll();
    }

    @MutationMapping(name = "orders")
    public OrderEntity orders(@Argument(name = "order") OrderEntity order) {
        log.info("OrderGraphQLController.orders");
        return orderRepository.save(order);
    }
}
