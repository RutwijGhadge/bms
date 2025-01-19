package com.example.bms.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Actor extends BaseModel{
    private String name;
}
