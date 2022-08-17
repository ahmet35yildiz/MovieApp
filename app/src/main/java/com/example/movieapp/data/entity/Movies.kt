package com.example.movieapp.data.entity

import java.io.Serializable

data class Movies(var movieId:String,
                  var movieTitle:String,
                  var movieGenre:String,
                  var moviePlot:String,
                  var movieYear:String,
                  var movieRuntime:String,
                  var movieLanguage:String,
                  var moviePoster:String) : Serializable {
}