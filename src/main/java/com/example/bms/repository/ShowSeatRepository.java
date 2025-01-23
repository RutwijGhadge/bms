package com.example.bms.repository;

import com.example.bms.models.Show;
import com.example.bms.models.ShowSeat;
import com.example.bms.models.ShowSeatType;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import java.util.List;

public interface ShowSeatRepository extends JpaRepository<ShowSeat,Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    ShowSeat save(ShowSeat seat);

    List<ShowSeatType> findAllByShow(Show show);
}
