package com.example.demo.service;

import com.example.demo.entity.Item;
import com.example.demo.repository.ItemRepository;
import jakarta.transaction.Transactional;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
    final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Scheduled(initialDelay = 1200)
    @Transactional
    public void dummyUpdate() {
        // will not execute any SQL update since the manipulated item does not differ from the persisted row
        System.out.println("Performing dummy item update");
        List<Item> items = itemRepository.findAll();
        String originalName = items.get(0).getName();
        items.get(0).setName("Foo");
        items.get(0).setName(originalName);
        itemRepository.saveAll(items);
    }
}
