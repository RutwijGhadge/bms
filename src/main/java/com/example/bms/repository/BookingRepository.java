package com.example.bms.repository;

import com.example.bms.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {
    //JPA repository is superset of CRUD+Pagination

    Booking save(Booking booking);
}