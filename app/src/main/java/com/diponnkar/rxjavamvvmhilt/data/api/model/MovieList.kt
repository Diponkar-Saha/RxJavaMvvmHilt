package com.diponnkar.rxjavamvvmhilt.data.api.model

import androidx.annotation.Keep
import com.diponnkar.rxjavamvvmhilt.data.api.model.Movie
import com.google.gson.annotations.SerializedName

@Keep
data class MovieList(@SerializedName("Search") val movieList: List<Movie>)