package com.example.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.login.R

class HomeFragment : Fragment() {

    private lateinit var recommendedRecyclerView: RecyclerView
    private lateinit var categoriesRecyclerView: RecyclerView
    private lateinit var titleText: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // Find views using findViewById
        titleText = view.findViewById(R.id.entertainmentTitle)
        recommendedRecyclerView = view.findViewById(R.id.recommendedRecyclerView)
        categoriesRecyclerView = view.findViewById(R.id.categoriesRecyclerView)

        // Set up the title text
        titleText.text = "Entertainment Time"

        // Set up RecyclerViews
        recommendedRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recommendedRecyclerView.adapter = RecommendedMoviesAdapter(getRecommendedMovies())

        categoriesRecyclerView.layoutManager = GridLayoutManager(context, 2)
        categoriesRecyclerView.adapter = CategoriesAdapter(getCategories())

        return view
    }

    private fun getRecommendedMovies(): List<Movie> {
        return List(14) {
            Movie(
                title = "Movie ${it + 1}",
                rating = "Rating: ${4.0 + it * 0.5}", // Example ratings (e.g., 4.0, 4.5, 5.0, ...)
                language = if (it % 2 == 0) "English" else "Hindi" // Alternating languages for demo
            )
        }
    }

    private fun getCategories(): List<Category> {
        return listOf(
            Category("Thriller", R.drawable.ic_launcher_foreground),
            Category("Comedy", R.drawable.ic_launcher_foreground),
            Category("Horror", R.drawable.ic_launcher_foreground),
            Category("Fantasy", R.drawable.ic_launcher_foreground)
        )
    }
}
