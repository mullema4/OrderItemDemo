package com.example.demo;

import com.example.demo.entity.Item;
import com.example.demo.entity.OrderEntry;
import com.example.demo.repository.ItemRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.service.OrderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DatabaseInitializer implements CommandLineRunner {

    final OrderRepository orderRepository;
    final ItemRepository itemRepository;
    final OrderService orderService;

    public DatabaseInitializer(OrderRepository orderRepository, ItemRepository itemRepository) {
        this.orderRepository = orderRepository;
        this.itemRepository = itemRepository;
        this.orderService = new OrderService(orderRepository);
    }

    @Override
    public void run(String... args) {
        Item item1 = new Item();
        item1.setId(1L);
        item1.setName("Item 1");
        Item item2 = new Item();
        item2.setId(2L);
        item2.setName("Item 2");
        Item item3 = new Item();
        item3.setId(3L);
        item3.setName("Item 3");
        Item item4 = new Item();
        item4.setId(4L);
        item4.setName("Item 4");
        itemRepository.saveAll(List.of(item1, item2, item3, item4));

        OrderEntry order1 = new OrderEntry();
        order1.setId(1L);
        order1.setItems(List.of(item1, item2));
        OrderEntry order2 = new OrderEntry();
        order2.setId(2L);
        order2.setItems(List.of(item3, item4));
        orderRepository.saveAllAndFlush(List.of(order1, order2));
        System.out.println("Initialization completed");
    }
}
