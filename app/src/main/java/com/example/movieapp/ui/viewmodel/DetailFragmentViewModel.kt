package com.example.movieapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.movieapp.data.entity.MovieDetail
import com.example.movieapp.data.repo.MoviesDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailFragmentViewModel @Inject constructor(private var mRepo: MoviesDaoRepository) : ViewModel() {

    val movieAllDetails: LiveData<MovieDetail> = mRepo.movieAllDetails

    fun showMovieDetail(movieId: String) {
        mRepo.showMovieDetail(movieId)
    }
}