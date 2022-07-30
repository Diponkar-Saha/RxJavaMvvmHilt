package com.diponnkar.rxjavamvvmhilt.data.repository

import com.diponnkar.rxjavamvvmhilt.data.api.ApiService
import javax.inject.Inject

class MainRepository @Inject constructor(private val retrofitService: ApiService) {
    fun getAllMovies() = retrofitService.getAllMovies()
}