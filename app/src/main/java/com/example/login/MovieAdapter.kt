import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.login.R


class MovieAdapter(private val movies: List<Movie>) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    // ViewHolder to hold the movie item layout
    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val movieImage: ImageView = itemView.findViewById(R.id.movieImage)
        val movieName: TextView = itemView.findViewById(R.id.movieName)
        val movieRating: TextView = itemView.findViewById(R.id.movieRating)
        val movieLanguage: TextView = itemView.findViewById(R.id.movieLanguage)
    }

    // Inflating the movie item layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return MovieViewHolder(view)
    }

    // Binding data to the view
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        holder.movieName.text = movie.title
        holder.movieRating.text = "Rating: ${movie.rating}"
        holder.movieLanguage.text = "Language: ${movie.language}"
        holder.movieImage.setImageResource(R.drawable.ic_launcher_foreground) // Replace with actual image
    }

    override fun getItemCount(): Int {
        return movies.size
    }
}
