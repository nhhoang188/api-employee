package com.example.apipaging.repository;

import com.example.apipaging.model.Office;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OfficeRepo extends JpaRepository<Office, Long> {
    @Query("select o from Office o WHERE o.name = ?1")
    Office findByName(String name);
}
