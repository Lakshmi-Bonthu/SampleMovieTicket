import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.login.R



class MovieFragment : Fragment() {

    private lateinit var movieRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_movie, container, false)

        // Initialize the RecyclerView
        movieRecyclerView = view.findViewById(R.id.recyclerViewMovies)

        // Setetting the LayoutManager to GridLayoutManager with 2 columns per row
        movieRecyclerView.layoutManager = GridLayoutManager(context, 2)

        // Settinf the Adapter to the RecyclerView
        val adapter = MovieAdapter(getMovies())
        movieRecyclerView.adapter = adapter

        return view
    }

    // Sample data for movies
    private fun getMovies(): List<Movie> {
        return List(14) { Movie("Movie ${it + 1}", "3.${it + 1}", "English/Telugu/Hindi") }
    }
}
