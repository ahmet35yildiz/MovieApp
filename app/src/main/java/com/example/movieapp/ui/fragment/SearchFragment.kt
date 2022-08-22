package com.example.movieapp.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.*
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentSearchBinding
import com.example.movieapp.ui.adapter.MoviesAdapter
import com.example.movieapp.ui.viewmodel.SearchFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment(), SearchView.OnQueryTextListener {
    private lateinit var binding: FragmentSearchBinding
    private val viewModel: SearchFragmentViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_search, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbarSearch)
        setHasOptionsMenu(true)
        binding.toolbarSearchTitle = "Movies"
        observe()
    }
    private fun observe() {
        viewModel.moviesList.observe(viewLifecycleOwner) {
            with(binding){
                if (it == null) {
                    animationViewNoData.visibility = View.VISIBLE
                    animationViewLoading.visibility = View.GONE
                    animationViewArrow.visibility = View.GONE
                    animationViewSearch.visibility = View.GONE
                    moviesAdapter = null
                } else {
                    val adapter = MoviesAdapter(it)
                    moviesAdapter = adapter
                    animationViewNoData.visibility = View.GONE
                    animationViewArrow.visibility = View.GONE
                    animationViewSearch.visibility = View.GONE
                    animationViewLoading.visibility = View.GONE
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_menu, menu)

        val item = menu.findItem(R.id.action_search)
        val searchView = item.actionView as SearchView
        searchView.setOnQueryTextListener(this)

        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        with(binding){
            animationViewLoading.visibility = View.VISIBLE
            animationViewNoData.visibility =  View.GONE
            animationViewSearch.visibility = View.GONE
            animationViewArrow.visibility = View.GONE
        }
        viewModel.showMovies(query)
        hideKeyboard()
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        return true
    }

    private fun hideKeyboard() {
        val imm =
            requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(requireView().windowToken, 0)
    }
}