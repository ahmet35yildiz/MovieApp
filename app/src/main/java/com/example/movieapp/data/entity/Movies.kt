package com.example.movieapp.data.entity

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Movies(
    @SerializedName("imdbID") var movieId: String?,
    @SerializedName("Title") var movieTitle: String?,
    @SerializedName("Type") var movieType: String?,
    @SerializedName("Year") var movieYear: String?,
    @SerializedName("Poster") var moviePoster: String?) : Serializable {
}