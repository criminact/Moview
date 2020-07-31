package com.noobcode.brief.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Movie {
    @SerializedName("adult")
    @Expose
    public Boolean adult;
    @SerializedName("backdrop_path")
    @Expose
    public String backdropPath;
    @SerializedName("id")
    @Expose
    public Integer id;
    @SerializedName(value="name", alternate={"original_name", "original_title"})
    @Expose
    public String originalTitle;
    @SerializedName("overview")
    @Expose
    public String overview;
    @SerializedName("poster_path")
    @Expose
    public String posterPath;
    @SerializedName(value="date", alternate={"first_air_date", "release_date"})
    @Expose
    public String releaseDate;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("vote_average")
    @Expose
    public Double voteAverage;
    @SerializedName("vote_count")
    @Expose
    public Integer voteCount;
    @SerializedName("popularity")
    @Expose
    public Double popularity;

    public Movie(Boolean adult, String backdropPath, Integer id, String originalTitle, String overview, String posterPath, String releaseDate, String title, Double voteAverage, Integer voteCount, Double popularity) {
        this.adult = adult;
        this.backdropPath = backdropPath;
        this.id = id;
        this.originalTitle = originalTitle;
        this.overview = overview;
        this.posterPath = posterPath;
        this.releaseDate = releaseDate;
        this.title = title;
        this.voteAverage = voteAverage;
        this.voteCount = voteCount;
        this.popularity = popularity;
    }
}
