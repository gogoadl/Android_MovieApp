package com.hyeonwoo.android_movie_app_mvvm.single_movie_details

import androidx.lifecycle.LiveData
import com.hyeonwoo.android_movie_app_mvvm.data.api.TheMovieDBInterface
import com.hyeonwoo.android_movie_app_mvvm.data.repository.MovieDetailsNetworkDataSource
import com.hyeonwoo.android_movie_app_mvvm.data.repository.NetworkState
import com.hyeonwoo.android_movie_app_mvvm.data.vo.MovieDetails
import io.reactivex.disposables.CompositeDisposable

class MovieDetailsRepository(private val apiService : TheMovieDBInterface) {

    lateinit var movieDetailsNetworkDataSource: MovieDetailsNetworkDataSource

    fun fetchSingleMovieDetails (compositeDisposable: CompositeDisposable, movieId: Int) : LiveData<MovieDetails> {

        movieDetailsNetworkDataSource = MovieDetailsNetworkDataSource(apiService,compositeDisposable)
        movieDetailsNetworkDataSource.fetchMovieDetails(movieId)

        return movieDetailsNetworkDataSource.downloadedMovieResponse
    }

    fun getMovieDetailsNetworkState(): LiveData<NetworkState> {
        return movieDetailsNetworkDataSource.networkState
    }
}