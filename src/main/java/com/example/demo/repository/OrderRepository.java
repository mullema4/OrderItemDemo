package com.example.demo.repository;

import com.example.demo.entity.OrderEntry;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntry, Long> {

    @EntityGraph(attributePaths = "items")
    List<OrderEntry> findAllByIdIn(List<Long> ids);
}
