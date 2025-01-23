package com.example.bms.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
public class Theatre extends BaseModel{
    private String name;
    private String address;

    @OneToMany
    private List<Auditorium>auditoriums;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Auditorium> getAuditoriums() {
        return auditoriums;
    }

    public void setAuditoriums(List<Auditorium> auditoriums) {
        this.auditoriums = auditoriums;
    }
}

/*
        Theatre     Auditorium
        1               M
        1               1

        Theatre:Auditorium -> 1:M
 */