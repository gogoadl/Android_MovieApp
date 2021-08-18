package com.hyeonwoo.android_movie_app_mvvm.data.vo


import com.google.gson.annotations.SerializedName

data class MovieDetails(
    val id: Int,
    val overview: String,
    val popularity: Double,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("release_date")
    val releaseDate: String,
    val title: String,
    val video: Boolean,
    @SerializedName("vote_average")
    val rating: Double
)