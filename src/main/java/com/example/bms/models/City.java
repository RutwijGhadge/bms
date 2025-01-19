package com.example.bms.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class City extends BaseModel{
//Id attribute will be extended from BaseModel Class

    @Column(name = "CityName")
    private String name;

    //city will be having List of Theaters
    @OneToMany
    List<Theatre> theatres;
}
