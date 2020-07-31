package com.noobcode.brief.network;
import com.noobcode.brief.model.Page;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieAPI {
    @GET("trending/all/week?api_key=06addf9a12af26a9abc40cd3cf2748a5")
    Single<Page> getMovies(@Query("page") int page);

    @GET("discover/movie?api_key=06addf9a12af26a9abc40cd3cf2748a5")
    Single<Page> getMoviesWithGenre(@Query("with_genres") String genre, @Query("page") int page);
}
