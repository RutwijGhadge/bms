package com.example.bms.service;

import com.example.bms.models.Show;
import com.example.bms.models.ShowSeat;
import com.example.bms.models.ShowSeatType;
import com.example.bms.repository.ShowSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PriceCalculatorServiceImpl {

    @Autowired
    private ShowSeatRepository showSeatRepository;

    //Calling from TicketServiceImpl
    public int calculatePrice(List<ShowSeat>showSeats,Show show){
        //List<ShowSeat>showSeats -> all the Showseats required to book
        int price=0;

        //List<ShowSeatType> showSeatTypeList : for a particular show these we have present in the auditorium
        List<ShowSeatType> showSeatTypeList=showSeatRepository.findAllByShow(show);

        /*
        check whether the given showSeat type matches with the seat type.
        if yes , add the price.
         */
       for(ShowSeat showSeat : showSeats){
           for (ShowSeatType showSeatType : showSeatTypeList){
                if(showSeat.getSeat().getSeatType().equals(showSeatType.getSeatType())){
                    price += showSeat.getPrice();
                    break;
                }
           }
       }
        return price;
    }
}
