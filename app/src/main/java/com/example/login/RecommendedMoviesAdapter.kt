import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.login.R

class RecommendedMoviesAdapter(private val movies: List<Movie>) : RecyclerView.Adapter<RecommendedMoviesAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recommended_movie_item, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = movies.size

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val movieName: TextView = itemView.findViewById(R.id.movieName)
        private val movieImage: ImageView = itemView.findViewById(R.id.movieImage)

        fun bind(movie: Movie) {
            movieName.text = movie.title
            movieImage.setImageResource(R.drawable.ic_launcher_foreground) // Replace with your image
        }
    }
}
