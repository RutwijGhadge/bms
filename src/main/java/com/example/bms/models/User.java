package com.example.bms.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class User extends BaseModel{
    private String name;
    private String email;

    private List<Ticket> ticketList;
}
