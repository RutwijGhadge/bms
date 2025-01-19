package com.example.bms.models;

import com.example.bms.models.constants.AuditoriumFeatures;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Auditorium extends BaseModel{

    private String name;

    @OneToMany
    private List<Show>shows;

    @OneToMany
    private List<Seat>seats;

    @Enumerated(EnumType.STRING)
    private List<AuditoriumFeatures>auditoriumFeatures;
}
