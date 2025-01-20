package com.example.bms.service;

import com.example.bms.exception.ShowSeatBookedException;
import com.example.bms.models.ShowSeat;
import com.example.bms.models.Ticket;
import com.example.bms.models.User;
import com.example.bms.models.constants.ShowSeatStatus;
import com.example.bms.models.constants.TicketStatus;
import com.example.bms.repository.ShowSeatRepository;
import com.example.bms.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TicketServiceImpl implements bookTickets{

    @Autowired
    private ShowSeatRepository showSeatRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Transactional(isolation = Isolation.SERIALIZABLE)
    @Override
    public Ticket bookTickets(List<Integer> showSeatIds, User user) throws ShowSeatBookedException {
        List<ShowSeat>showSeats=showSeatRepository.findAllById(showSeatIds);
        //Fetching all the seats at once instead of fetching the showseat one by one to reduce the DB calls
        for(ShowSeat seat: showSeats){
            if(!seat.getShowSeatStatus().equals(ShowSeatStatus.Booked)){
                throw new ShowSeatBookedException("Sorry !!! ShowSeat is Already Booked");
            }
        }
        //Setting the seat status to Locked if all the seats are available
        showSeats.forEach(se-> se.setShowSeatStatus(ShowSeatStatus.Locked));
        showSeatRepository.saveAll(showSeats);

//        Ticket ticket=new Ticket();
//        ticket.setTicketStatus(TicketStatus.Booked);
//        ticket.setTimeOfBooking(LocalDateTime.now());
//        ticket.setShowSeatList(showSeats);
//        ticket.setAmount(100);
      //  return ticketRepository.save(ticket);
        return null;
    }
}
