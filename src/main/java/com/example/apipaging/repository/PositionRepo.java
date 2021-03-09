package com.example.apipaging.repository;

import com.example.apipaging.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PositionRepo extends JpaRepository<Position, Long> {
    @Query("select o from Position o WHERE o.name = ?1")
    Position findByName(String name);
}
