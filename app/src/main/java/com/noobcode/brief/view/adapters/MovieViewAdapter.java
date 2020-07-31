package com.noobcode.brief.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.noobcode.brief.R;
import com.noobcode.brief.model.Movie;
import com.noobcode.brief.model.MovieClickListener;
import com.noobcode.brief.utils.GlideUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieViewAdapter extends RecyclerView.Adapter<MovieViewAdapter.ViewHolder> implements MovieClickListener {

    List<Movie> movies;

    public MovieViewAdapter(List<Movie> movies) {
        this.movies = movies;
    }

    public void updateMovies(List<Movie> movies) {
        this.movies.clear();
        this.movies = movies;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_card, parent, false);
        return new MovieViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(movies.get(position).originalTitle);
        GlideUtils.loadImage(holder.image, "https://image.tmdb.org/t/p/w200" + movies.get(position).posterPath, GlideUtils.getLoader(holder.image.getContext()));
        holder.ratings.setText(String.valueOf(movies.get(position).voteAverage));
        holder.release.setText(movies.get(position).releaseDate);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    @Override
    public void onClicked(View v) {
        Toast.makeText(v.getContext(), "Clicked", Toast.LENGTH_SHORT).show();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.movie_title)
        TextView title;

        @BindView(R.id.movie_image)
        ImageView image;

        @BindView(R.id.movie_rating)
        TextView ratings;

        @BindView(R.id.movie_release)
        TextView release;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
