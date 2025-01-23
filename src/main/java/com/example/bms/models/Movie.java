package com.example.bms.models;

import com.example.bms.models.constants.MovieFeatures;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
public class Movie extends BaseModel{

    private String name;
    private String description;
    private String language;

    @ManyToMany
    private List<Actor> actorList;

    @Enumerated(EnumType.STRING)
    private List<MovieFeatures>movieFeatures;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MovieFeatures> getMovieFeatures() {
        return movieFeatures;
    }

    public void setMovieFeatures(List<MovieFeatures> movieFeatures) {
        this.movieFeatures = movieFeatures;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public List<Actor> getActorList() {
        return actorList;
    }

    public void setActorList(List<Actor> actorList) {
        this.actorList = actorList;
    }
}
