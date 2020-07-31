package com.noobcode.brief.network;

import com.noobcode.brief.model.Movie;
import com.noobcode.brief.model.Page;

import io.reactivex.Single;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitMovieService {

    public static final String BASE_URL = "https://api.themoviedb.org/3/";
    private MovieAPI api;

    public RetrofitMovieService(){
        api = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(MovieAPI.class);
    }

    public Single<Page> getMovies(int page){
        return api.getMovies(page);
    }

    public Single<Page> getMoviesWithGenres(String genreId, int page){
        return api.getMoviesWithGenre(genreId, page);
    }
}
