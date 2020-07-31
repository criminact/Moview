package com.noobcode.brief.view.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.noobcode.brief.R;
import com.noobcode.brief.model.Movie;
import com.noobcode.brief.model.Page;
import com.noobcode.brief.view.adapters.MovieViewAdapter;
import com.noobcode.brief.viewmodel.MovieListViewModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MovieListFragment extends Fragment {

    @BindView(R.id.movie_recyclerview)
    RecyclerView moviewView;

    @BindView(R.id.error_string)
    TextView error;

    @BindView(R.id.progress)
    ProgressBar progress;

    @BindView(R.id.previous)
    FloatingActionButton previous;

    @BindView(R.id.next)
    FloatingActionButton next;

    private MovieListViewModel viewModel;
    private Unbinder unbinder;

    private MovieViewAdapter movieViewAdapter = new MovieViewAdapter(new ArrayList<>());

    public MovieListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie_list, container, false);
        viewModel = new ViewModelProvider(this).get(MovieListViewModel.class);
        unbinder = ButterKnife.bind(this, view);
        setHasOptionsMenu(true);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        moviewView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        moviewView.setAdapter(movieViewAdapter);

        next.setOnClickListener(v -> {
            viewModel.pageNext();
        });

        previous.setOnClickListener(v -> {
            viewModel.pagePrevious();
        });

        viewModel.refresh();

        observeData();
    }

    private void observeData() {
        viewModel.page.observe(this, page -> {
            if(page != null && page instanceof Page){
                movieViewAdapter.updateMovies(page.results);
            }
        });

        viewModel.error.observe(this, isError -> {
            if(isError != null && isError instanceof Boolean){
                if(isError){
                    error.setVisibility(View.VISIBLE);
                }else{
                    error.setVisibility(View.GONE);
                }
            }
        });

        viewModel.loading.observe(this, isLoading -> {
            if(isLoading != null && isLoading instanceof Boolean){
                if(isLoading){
                    progress.setVisibility(View.VISIBLE);
                }else{
                    progress.setVisibility(View.GONE);
                }
            }
        });

        viewModel.leftFab.observe(this, isShown -> {
            if(isShown != null && isShown instanceof Boolean){
                previous.setVisibility(isShown ? View.VISIBLE : View.GONE);
            }
        });

        viewModel.rightFab.observe(this, isShown -> {
            if(isShown != null && isShown instanceof Boolean){
                next.setVisibility(isShown ? View.VISIBLE : View.GONE);
            }
        });
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.genre_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.actionGen:{
                viewModel.refresh(String.valueOf(28));
                break;
            }

            case R.id.adventureGen:{
                viewModel.refresh(String.valueOf(12));
                break;
            }

            case R.id.animationGen:{
                viewModel.refresh(String.valueOf(16));
                break;
            }

            case R.id.comedyGen:{
                viewModel.refresh(String.valueOf(35));
                break;
            }

            case R.id.crimeGen:{
                viewModel.refresh(String.valueOf(80));
                break;
            }

            case R.id.documentaryGen:{
                viewModel.refresh(String.valueOf(99));
                break;
            }

            case R.id.familyGen:{
                viewModel.refresh(String.valueOf(10751));
                break;
            }

            case R.id.fantasyGen:{
                viewModel.refresh(String.valueOf(14));
                break;
            }

            case R.id.historyGen:{
                viewModel.refresh(String.valueOf(36));
                break;
            }

            case R.id.horrorGen:{
                viewModel.refresh(String.valueOf(27));
                break;
            }

            case R.id.musicGen:{
                viewModel.refresh(String.valueOf(10402));
                break;
            }

            case R.id.mysteryGen:{
                viewModel.refresh(String.valueOf(9648));
                break;
            }

            case R.id.romanceGen:{
                viewModel.refresh(String.valueOf(10749));
                break;
            }

            case R.id.scifiGen:{
                viewModel.refresh(String.valueOf(878));
                break;
            }

            case R.id.thrillerGen:{
                viewModel.refresh(String.valueOf(53));
                break;
            }

            case R.id.warGen:{
                viewModel.refresh(String.valueOf(10752));
                break;
            }

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
