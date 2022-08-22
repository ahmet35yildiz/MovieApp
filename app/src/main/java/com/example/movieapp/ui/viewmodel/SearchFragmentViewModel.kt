package com.example.movieapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.movieapp.data.entity.Movies
import com.example.movieapp.data.repo.MoviesDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchFragmentViewModel @Inject constructor(private var mRepo: MoviesDaoRepository) : ViewModel() {
    var moviesList: LiveData<List<Movies>?> = mRepo.moviesList

    fun showMovies(searchTerm: String) {
        mRepo.searchResult(searchTerm)
    }
}