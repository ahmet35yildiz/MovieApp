package com.example.movieapp.data.entity

import com.google.gson.annotations.SerializedName

data class MoviesResponse(
    @SerializedName("Search") var search: List<Movies>?,
    @SerializedName("totalResults") var totalResults: String,
    @SerializedName("Response") var response: String) {
}