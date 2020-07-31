package com.noobcode.brief.viewmodel;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.noobcode.brief.model.Movie;
import com.noobcode.brief.model.Page;
import com.noobcode.brief.network.RetrofitMovieService;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class MovieListViewModel extends ViewModel {

    private int pageCount = 1;
    private String genreId = null;
    public MutableLiveData<Boolean> leftFab = new MutableLiveData<Boolean>();
    public MutableLiveData<Boolean> rightFab = new MutableLiveData<Boolean>();
    public MutableLiveData<Page> page = new MutableLiveData<Page>();
    public MutableLiveData<Boolean> error = new MutableLiveData<Boolean>();
    public MutableLiveData<Boolean> loading = new MutableLiveData<Boolean>();
    private RetrofitMovieService service = new RetrofitMovieService();
    private CompositeDisposable disposable = new CompositeDisposable();

    public void refresh() {
        refreshFromRemote();
    }

    public void refresh(String genreId) {
        this.genreId = genreId;
        refreshFromRemoteWithGenre(genreId);
    }

    private void refreshFromRemoteWithGenre(String genreId) {
        checkPage();
        error.setValue(false);
        loading.setValue(true);
        disposable.add(
                service.getMoviesWithGenres(genreId, pageCount)
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableSingleObserver<Page>() {
                            @Override
                            public void onSuccess(Page tempPage) {
                                page.setValue(tempPage);
                                error.setValue(false);
                                loading.setValue(false);
                            }

                            @Override
                            public void onError(Throwable e) {
                                error.setValue(true);
                                loading.setValue(false);
                                e.printStackTrace();
                            }
                        }));
    }

    public void pagePrevious() {
        if (pageCount != 1) {
            pageCount--;
            if (genreId == null) {
                refresh();
            } else {
                refresh(genreId);
            }
        }
    }

    public void pageNext() {
        if (pageCount != 5) {
            pageCount++;
            if (genreId == null) {
                refresh();
            } else {
                refresh(genreId);
            }
        }
    }

    private void refreshFromRemote() {
        checkPage();
        error.setValue(false);
        loading.setValue(true);
        disposable.add(
                service.getMovies(pageCount)
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableSingleObserver<Page>() {
                            @Override
                            public void onSuccess(Page tempPage) {
                                page.setValue(tempPage);
                                error.setValue(false);
                                loading.setValue(false);
                            }

                            @Override
                            public void onError(Throwable e) {
                                error.setValue(true);
                                loading.setValue(false);
                                e.printStackTrace();
                            }
                        }));

    }

    private void checkPage() {
        if (pageCount == 1) {
            leftFab.setValue(false);
        } else {
            leftFab.setValue(true);
        }

        if (pageCount == 5) {
            rightFab.setValue(false);
        } else {
            rightFab.setValue(true);
        }
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}
