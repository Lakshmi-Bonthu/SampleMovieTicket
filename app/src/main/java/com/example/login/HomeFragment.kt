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
import com.example.login.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var recommendedRecyclerView: RecyclerView
    private lateinit var categoriesRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHomeBinding.inflate(inflater, container, false)

        // Set up the title text
        val titleText: TextView = binding.entertainmentTitle
        titleText.text = "Entertainment Time"

        // Set up RecyclerViews
        recommendedRecyclerView = binding.recommendedRecyclerView
        recommendedRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recommendedRecyclerView.adapter = RecommendedMoviesAdapter(getRecommendedMovies())

        categoriesRecyclerView = binding.categoriesRecyclerView
        categoriesRecyclerView.layoutManager = GridLayoutManager(context, 2)
        categoriesRecyclerView.adapter = CategoriesAdapter(getCategories())

        return binding.root
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

