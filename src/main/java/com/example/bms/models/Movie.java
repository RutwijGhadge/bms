package com.example.bms.models;

import com.example.bms.models.constants.MovieFeatures;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Movie extends BaseModel{

    private String name;
    private String description;
    private String language;

    @ManyToMany
    private List<Actor> actorList;

    @Enumerated(EnumType.STRING)
    private List<MovieFeatures>movieFeatures;
}
