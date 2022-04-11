package id.arajangstudio.moviecatalogue.ui.tvshow

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


class TvShowAdapter : RecyclerView.Adapter<TvShowAdapter.TvShowViewHolder>() {
    private var listTvShow = ArrayList<DataEntity>()

    fun setTvShow(tvshow: List<DataEntity>?) {
        if (tvshow == null) return
        this.listTvShow.clear()
        this.listTvShow.addAll(tvshow)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val itemsMoviesBinding =
            ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowViewHolder(itemsMoviesBinding)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        val course = listTvShow[position]
        holder.bind(course)
    }

    override fun getItemCount(): Int = listTvShow.size


    class TvShowViewHolder(private val binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tvshow: DataEntity) {
            with(binding) {
                tvTitle.text = tvshow.title
                tvYear.text = tvshow.year
                tvGenre.text = tvshow.genre
                tvRating.bringToFront()
                tvRating.background.alpha = 128
                tvRating.text = " " + tvshow.rating + " "


                btnShare.setOnClickListener {
                    val shareIntent = Intent(Intent.ACTION_SEND)
                    shareIntent.type = "text/plain"
                    shareIntent.putExtra(Intent.EXTRA_TEXT, tvshow.url)
                    itemView.context.startActivity(
                        Intent.createChooser(
                            shareIntent,
                            "Share link using"
                        )
                    )
                }
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_MOVIEORTVSHOW, tvshow.id)
                    intent.putExtra("category", "isTvshow")
                    itemView.context.startActivity(intent)
                }

                Glide.with(itemView.context)
                    .load(tvshow.imagePath)
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