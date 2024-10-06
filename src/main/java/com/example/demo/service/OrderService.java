package com.example.demo.service;

import com.example.demo.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Scheduled(initialDelay = 1000)
    @Transactional
    public void checkOrder() {
        System.out.println("Checking all orders");
        orderRepository.findAll().forEach(
                orderEntry -> orderEntry.getItems().forEach(item -> System.out.println(item.getName()))
        );
    }

    @Scheduled(initialDelay = 1100)
    @Transactional
    public void checkOrdersSmart() {
        System.out.println("Checking all orders smart");
        orderRepository.findAllByIdIn(List.of(1L, 2L)).forEach(
                orderEntry -> orderEntry.getItems().forEach(item -> System.out.println(item.getName()))
        );
    }
}