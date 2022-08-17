package com.example.movieapp.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieapp.R
import com.example.movieapp.data.entity.Movies
import com.example.movieapp.databinding.FragmentSearchBinding
import com.example.movieapp.ui.adapter.MoviesAdapter

class SearchFragment : Fragment(),SearchView.OnQueryTextListener {
    private lateinit var binding: FragmentSearchBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSearchBinding.inflate(inflater, container, false)

        (activity as AppCompatActivity).setSupportActionBar(binding.toolbarSearch)

       // binding.toolbarSearch.title =
        binding.rvSearch.layoutManager = LinearLayoutManager(requireContext())

        val moviesList = ArrayList<Movies>()
        val m1 = Movies("1","STAR WARS","Action, Adventure, Fantasy","SADSDFDSFA","1977","121 min","English","starwars")
        val m2 = Movies("2","BATMAN","Action, Adventure","QWEQWEWQEQ","1999","110 min","English","batman")
        val m3 = Movies("3","TITANIC","Drama, Romance","ZXCZXCXZCZC","1995","98 min","English","titanic")
        moviesList.add(m1)
        moviesList.add(m2)
        moviesList.add(m3)

        val adapter = MoviesAdapter(requireContext(),moviesList)
        binding.rvSearch.adapter = adapter

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_menu,menu)

        val item = menu.findItem(R.id.action_search)
        val searchView = item.actionView as SearchView
        searchView.setOnQueryTextListener(this)

        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        search(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        search(newText)
        return true
    }

    fun search(searchTerm:String) {
        Log.e("search",searchTerm)
    }
}