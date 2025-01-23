package com.example.bms.models;

import com.example.bms.models.constants.BookingStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
public class Booking extends BaseModel{
    @ManyToMany
    private List<ShowSeat> showSeats;

    @ManyToOne
    private User user;

    /* Here in booking status we want to store just the string value of BookingStatus enum
    not the whole string, so we used this annotation to mark it as an Enumerated attribute
    and declared the type as number by giving the type as EnumType.ORDINAL.
    */
    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus;

    private int amount;

    @OneToMany
    private List<Payment> payments;

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public List<ShowSeat> getShowSeats() {
        return showSeats;
    }

    public void setShowSeats(List<ShowSeat> showSeats) {
        this.showSeats = showSeats;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
