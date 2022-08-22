package com.example.movieapp.data.entity

import com.google.gson.annotations.SerializedName

data class MovieDetail(
    @SerializedName("Title") var movieTitle: String?,
    @SerializedName("Genre") var movieGenre: String?,
    @SerializedName("Plot") var moviePlot: String?,
    @SerializedName("Year") var movieYear: String?,
    @SerializedName("Runtime") var movieRuntime: String?,
    @SerializedName("Language") var movieLanguage: String?,
    @SerializedName("Poster") var moviePoster: String?) {
}