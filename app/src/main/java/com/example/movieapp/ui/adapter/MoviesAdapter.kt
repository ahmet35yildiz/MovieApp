package com.example.movieapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.R
import com.example.movieapp.data.entity.Movies
import com.example.movieapp.databinding.CardDesignSearchBinding
import com.example.movieapp.ui.fragment.SearchFragmentDirections
import com.squareup.picasso.Picasso

class MoviesAdapter(private var moviesList: List<Movies>) :
    RecyclerView.Adapter<MoviesAdapter.CardDesignHolder>() {

    inner class CardDesignHolder(binding: CardDesignSearchBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var binding: CardDesignSearchBinding

        init {
            this.binding = binding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: CardDesignSearchBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.card_design_search, parent, false)
        return CardDesignHolder(binding)
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val movie = moviesList[position]

        with(holder.binding){
            movieObject = movie

            Picasso.get().load(movie.moviePoster).into(imageViewMoviePoster)

            cardViewMovie.setOnClickListener {
                movie.movieId?.let { id ->
                    val transition = SearchFragmentDirections.detailTransition(movie = id)
                    Navigation.findNavController(it).navigate(transition)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }
}