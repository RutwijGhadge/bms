package com.example.bms.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "bms_user") //Since User is a Reselved Keyword we cannot use it directly for table name
public class User extends BaseModel{
    private String name;
    private String email;

    @OneToMany
    private List<Ticket>ticketList;

}
/*
User        Ticket
1               M
1               1

user:ticket : One To Many
 */