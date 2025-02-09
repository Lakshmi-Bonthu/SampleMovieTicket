package com.example.login


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.login.R

class MovieFragment : Fragment() {

    private lateinit var movieRecyclerView: RecyclerView
    private lateinit var movieAdapter: MovieAdapter
    private lateinit var allMovies: List<Movie> // To keep the original list of movies
    private var filteredMovies: MutableList<Movie> = mutableListOf() // For the filtered list

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_movie, container, false)

        // Initialize the RecyclerView
        movieRecyclerView = view.findViewById(R.id.recyclerViewMovies)

        // Set the LayoutManager to GridLayoutManager with 2 columns per row
        movieRecyclerView.layoutManager = GridLayoutManager(context, 2)

        // Initialize movie data
        allMovies = getMovies()
        filteredMovies.addAll(allMovies)

        // Set the Adapter to the RecyclerView
        movieAdapter = MovieAdapter(filteredMovies)
        movieRecyclerView.adapter = movieAdapter

        // Initialize the SearchView
        val searchView: SearchView = view.findViewById(R.id.searchView)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                // Do nothing for query submit
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterMovies(newText.orEmpty())
                return true
            }
        })

        return view
    }

    // Sample data for movies
    private fun getMovies(): List<Movie> {
        return List(14) { Movie("Movie ${it + 1}", "3.5.${it + 0.1}", "English/Telugu/Hindi") }
    }

    // Filter movies based on the search query
    private fun filterMovies(query: String) {
        filteredMovies.clear()
        if (query.isEmpty()) {
            filteredMovies.addAll(allMovies)
        } else {
            for (movie in allMovies) {
                if (movie.title.contains(query, ignoreCase = true)) {
                    filteredMovies.add(movie)
                }
            }
        }
        movieAdapter.notifyDataSetChanged()
    }
}
