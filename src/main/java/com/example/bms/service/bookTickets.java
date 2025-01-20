package com.example.bms.service;

import com.example.bms.exception.ShowSeatBookedException;
import com.example.bms.models.ShowSeat;
import com.example.bms.models.Ticket;
import com.example.bms.models.User;

import java.util.List;

public interface bookTickets {
    public Ticket bookTickets(List<Integer> showSeatIds, User user) throws ShowSeatBookedException;
}
