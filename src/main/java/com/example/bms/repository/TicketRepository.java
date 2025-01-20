package com.example.bms.repository;

import com.example.bms.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Integer> {
    //JPA repository is superset of CRUD+Pagination

}