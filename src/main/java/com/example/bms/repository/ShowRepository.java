package com.example.bms.repository;

import com.example.bms.models.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

public interface ShowRepository extends JpaRepository<Show, Long> {
    Show findShowById(Long id);
}
