package com.example.movieapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.data.entity.Movies
import com.example.movieapp.databinding.CardDesignSearchBinding
import com.example.movieapp.ui.fragment.SearchFragmentDirections

class MoviesAdapter(var mContext:Context, var moviesList:List<Movies>) : RecyclerView.Adapter<MoviesAdapter.CardDesignHolder>(){

    inner class CardDesignHolder(binding: CardDesignSearchBinding) : RecyclerView.ViewHolder(binding.root){
        var binding:CardDesignSearchBinding
        init {
            this.binding = binding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val binding = CardDesignSearchBinding.inflate(layoutInflater,parent,false)
        return CardDesignHolder(binding)
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val movie = moviesList.get(position)
        val b = holder.binding
        b.imageViewMoviePoster.setImageResource(mContext.resources.getIdentifier(movie.moviePoster,"drawable",mContext.packageName))
        b.textViewMovieTitle.text = movie.movieTitle
        b.textViewMovieGenre.text = movie.movieGenre
        b.textViewMoviePlot.text = movie.moviePlot
        b.cardViewMovie.setOnClickListener {
            val transition = SearchFragmentDirections.detailTransition(movie = movie)
            Navigation.findNavController(it).navigate(transition)
        }
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }
}