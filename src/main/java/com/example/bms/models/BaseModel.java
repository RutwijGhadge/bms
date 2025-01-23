package com.example.bms.models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
public abstract class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;     //primary key : Automatic Generation

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
