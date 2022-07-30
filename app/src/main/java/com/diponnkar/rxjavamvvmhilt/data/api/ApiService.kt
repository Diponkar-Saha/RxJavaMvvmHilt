package com.diponnkar.rxjavamvvmhilt.data.api

import com.diponnkar.rxjavamvvmhilt.data.api.model.MovieList
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface ApiService {
    @GET("api?s=batman")
    fun getAllMovies(): Observable<MovieList>
}