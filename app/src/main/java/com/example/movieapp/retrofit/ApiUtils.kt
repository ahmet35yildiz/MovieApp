package com.example.movieapp.retrofit

class ApiUtils {
    companion object {
        private const val BASE_URL = "https://www.omdbapi.com/"

        fun getMoviesDao(): MoviesDao {
            return RetrofitClient.getClient(BASE_URL).create(MoviesDao::class.java)
        }
    }
}