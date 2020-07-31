package com.noobcode.brief.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Page {
    @SerializedName("page")
    @Expose
    public Integer page;
    @SerializedName("results")
    @Expose
    public List<Movie> results = null;

    public Page(Integer page, List<Movie> results) {
        this.page = page;
        this.results = results;
    }
}