package id.arajangstudio.moviecatalogue.ui.movie

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import id.arajangstudio.moviecatalogue.R
import id.arajangstudio.moviecatalogue.data.DataEntity
import id.arajangstudio.moviecatalogue.databinding.ListItemBinding
import id.arajangstudio.moviecatalogue.ui.detail.DetailActivity

class MoviesAdapter : RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {
    private var listMovies = ArrayList<DataEntity>()

    fun setMovies(movies: List<DataEntity>?) {
        if (movies == null) return
        this.listMovies.clear()
        this.listMovies.addAll(movies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val itemsMoviesBinding =
            ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesViewHolder(itemsMoviesBinding)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movies = listMovies[position]
        holder.bind(movies)
    }

    override fun getItemCount(): Int = listMovies.size


    class MoviesViewHolder(private val binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(movies: DataEntity) {
            with(binding) {
                tvTitle.text = movies.title
                tvYear.text = movies.year
                tvGenre.text = movies.genre
                tvRating.bringToFront()
                tvRating.background.alpha = 128
                tvRating.text = " " + movies.rating + " "

                btnShare.setOnClickListener {
                    val shareIntent = Intent(Intent.ACTION_SEND)
                    shareIntent.type = "text/plain"
                    shareIntent.putExtra(Intent.EXTRA_TEXT, movies.url)
                    itemView.context.startActivity(
                        Intent.createChooser(
                            shareIntent,
                            "Share link using"
                        )
                    )
                }

                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_MOVIEORTVSHOW, movies.id)
                    intent.putExtra("category", "isMovie")
                    itemView.context.startActivity(intent)
                }


                Glide.with(itemView.context)
                    .load(movies.imagePath)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error)
                            .apply(RequestOptions.bitmapTransform(RoundedCorners(14)))
                    )
                    .into(imgPoster)
            }
        }
    }
}