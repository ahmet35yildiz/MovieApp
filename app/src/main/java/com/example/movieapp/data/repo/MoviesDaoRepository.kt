package com.example.movieapp.data.repo

import androidx.lifecycle.MutableLiveData
import com.example.movieapp.data.entity.MovieDetail
import com.example.movieapp.data.entity.Movies
import com.example.movieapp.data.entity.MoviesResponse
import com.example.movieapp.retrofit.MoviesDao
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviesDaoRepository(private var mDao: MoviesDao) {
    var moviesList = MutableLiveData<List<Movies>?>()
    var movieAllDetails = MutableLiveData<MovieDetail>()
    var responseError = MutableLiveData<String>()

    fun searchResult(searchTerm: String) {
        mDao.searchResult(searchTerm).enqueue(object : Callback<MoviesResponse> {
            override fun onResponse(
                call: Call<MoviesResponse>?,
                response: Response<MoviesResponse>
            ) {
                val answer = response.body().search
                if (answer == null) {
                    moviesList.value = null
                } else {
                    moviesList.value = answer
                }
            }

            override fun onFailure(call: Call<MoviesResponse>?, t: Throwable?) {
                responseError.value = t.toString()
            }
        })
    }

    fun showMovieDetail(movieId: String) {
        mDao.searchResultById(movieId).enqueue(object : Callback<MovieDetail> {
            override fun onResponse(call: Call<MovieDetail>?, response: Response<MovieDetail>) {
                movieAllDetails.value = response.body()
            }

            override fun onFailure(call: Call<MovieDetail>?, t: Throwable?) {
                responseError.value = t.toString()
            }
        })
    }
}