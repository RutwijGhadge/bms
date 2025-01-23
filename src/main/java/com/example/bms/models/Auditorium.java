package com.example.bms.models;

import com.example.bms.models.constants.AuditoriumFeatures;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
public class Auditorium extends BaseModel{

    private String name;

    @OneToMany
    private List<Show>shows;

    @OneToMany
    private List<Seat>seats;

    @Enumerated(EnumType.STRING)
    private List<AuditoriumFeatures>auditoriumFeatures;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AuditoriumFeatures> getAuditoriumFeatures() {
        return auditoriumFeatures;
    }

    public void setAuditoriumFeatures(List<AuditoriumFeatures> auditoriumFeatures) {
        this.auditoriumFeatures = auditoriumFeatures;
    }

    public List<Show> getShows() {
        return shows;
    }

    public void setShows(List<Show> shows) {
        this.shows = shows;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
}
