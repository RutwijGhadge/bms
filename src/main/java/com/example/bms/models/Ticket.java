package com.example.bms.models;

import com.example.bms.models.constants.TicketStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Setter
@Getter
public class Ticket extends BaseModel{

    @ManyToOne
    private Show show;

    @ManyToMany
    private List<ShowSeat> showSeatList;

    private int amount;

    @Enumerated(EnumType.STRING)
    private TicketStatus ticketStatus;

    private LocalDateTime timeOfBooking;
}


/*
Ticket      Show
1           1
M           1

Ticket : Show -> ManyToOne

Ticket    ShowSeat
1           M
M           1
Ticket : Showseat -> M:M
 */
