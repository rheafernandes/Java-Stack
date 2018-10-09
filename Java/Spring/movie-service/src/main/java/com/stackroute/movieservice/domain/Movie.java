package com.stackroute.movieservice.domain;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//import javax.persistence.Entity;
//import javax.persistence.Id;
@Document
//@Entity
public class Movie {
    @Id
    @ApiModelProperty(notes="Movie Id")
    private String id;
    @ApiModelProperty(notes="Movie Title")
    private String title;
    @ApiModelProperty(notes="User Rating")
    private float rating;
    @ApiModelProperty(notes="Year of Release")
    private String yearOfRelease;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(String yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public Movie() {
    }

    public Movie(String id, String title, float rating, String yearOfRelease) {
        this.id = id;
        this.title = title;
        this.rating = rating;
        this.yearOfRelease = yearOfRelease;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", rating=" + rating +
                ", yearOfRelease='" + yearOfRelease + '\'' +
                '}';
    }
}
