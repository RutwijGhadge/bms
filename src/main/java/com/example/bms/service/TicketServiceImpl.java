package com.example.bms.service;

import com.example.bms.exception.ShowSeatBookedException;
import com.example.bms.exception.showNotAvailableException;
import com.example.bms.exception.userNotFoundException;
import com.example.bms.models.Show;
import com.example.bms.models.ShowSeat;
import com.example.bms.models.Booking;
import com.example.bms.models.User;
import com.example.bms.models.constants.BookingStatus;
import com.example.bms.models.constants.ShowSeatStatus;
import com.example.bms.repository.ShowRepository;
import com.example.bms.repository.ShowSeatRepository;
import com.example.bms.repository.BookingRepository;
import com.example.bms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl{
/*
In the ticketBooking for Movies Service
1. Find the User with the particular UserId
2. Find the show with the showId
3. Check if all the seats are available for the Booking or Not
4. If yes , proceed with the Booking , or else throw the Exception.
-------------Take a Lock ---------------
5. check if all the seats are available.
6. change the status of the seats to Locked .
------------Release the Lock -----------
7. Create the Booking page and Move to Payment Page

 */
    @Autowired
    private ShowSeatRepository showSeatRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ShowRepository showRepository;

    private PriceCalculatorServiceImpl priceCalculatorService;

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking bookTickets(Long userId, Long showId, List<Long> showSeatIds) throws showNotAvailableException, userNotFoundException, ShowSeatBookedException {
       Optional<User>optionalUser=userRepository.findById(userId);
        if(optionalUser.isEmpty()){
            throw new userNotFoundException("User with userId:"+userId+" is Not Present.");
        }
        //if the user is present , Fetch the user from optionalUser object.
        User user = optionalUser.get();

        Optional<Show>optionalShow=showRepository.findById(showId);
        if(optionalShow.isEmpty()){
            throw new showNotAvailableException("Show with showId :"+showId+"is Not Available");
        }
        Show show=optionalShow.get();

        //Fetching all the seats at once instead of fetching the showSeat one by one to reduce the DB calls
        List<ShowSeat>showSeats=showSeatRepository.findAllById(showSeatIds);

        for(ShowSeat showseat: showSeats){
            if(!showseat.getShowSeatStatus().equals(ShowSeatStatus.Available)){
                throw new ShowSeatBookedException("Sorry !!! ShowSeat is not available for the Booking.");
            }
        }

        //If all the seats from the showSeatIds are Available then change the status of the seats to locked.
        for(ShowSeat seat: showSeats){
            seat.setShowSeatStatus(ShowSeatStatus.Locked);
            showSeatRepository.save(seat);
        }

        //Create the booking and Move to the Payment page
        Booking booking=new Booking();
        booking.setBookingStatus(BookingStatus.Pending);
        booking.setUser(user);
        booking.setShowSeats(showSeats);
        booking.setAmount(priceCalculatorService.calculatePrice(showSeats,show));

        bookingRepository.save(booking);
        return booking;

    }
}
