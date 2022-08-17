package com.example.movieapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)

        val bundle:DetailFragmentArgs by navArgs()
        val movieDetail = bundle.movie

        binding.toolbarDetail.title = movieDetail.movieTitle
        binding.imageViewDetailPoster.setImageResource(resources.getIdentifier(movieDetail.moviePoster,"drawable",requireContext().packageName))
        binding.textViewDetailPlot.text = movieDetail.moviePlot
        binding.textViewDetailGenre.text = movieDetail.movieGenre
        binding.textViewDetailRuntime.text = movieDetail.movieRuntime
        binding.textViewDetailYear.text = movieDetail.movieYear
        binding.textViewDetailLanguage.text = movieDetail.movieLanguage

        return binding.root
    }
}