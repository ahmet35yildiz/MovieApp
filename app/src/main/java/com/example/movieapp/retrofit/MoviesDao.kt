package com.example.movieapp.retrofit

import com.example.movieapp.data.entity.MovieDetail
import com.example.movieapp.data.entity.MoviesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesDao {
    @GET("?apikey=ae67ea1a")
    fun searchResult(@Query("s") term: String): Call<MoviesResponse>

    @GET("?apikey=ae67ea1a")
    fun searchResultById(@Query("i") movieId: String): Call<MovieDetail>
}