package com.example.bms.models;

import com.example.bms.models.constants.ShowSeatStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class ShowSeat extends BaseModel{
    @ManyToOne
    private Show show;

    private int price;

    @ManyToOne
    private Seat seat;

    @Enumerated(EnumType.STRING)
    private ShowSeatStatus showSeatStatus;
}
