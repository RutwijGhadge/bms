package com.example.bms.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
public class Show extends BaseModel{
    @ManyToOne
    private Auditorium auditorium;

    private LocalDate startTime;
    private LocalDate endTime;

    @ManyToOne
    private Movie movie;

    @OneToMany
    List<ShowSeat> showSeats;

}
/*
        show        audi
        1           1
        many        1

        show        movie
        1             1
        many          1
 */