package id.arajangstudio.moviecatalogue.ui.detail

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import id.arajangstudio.moviecatalogue.R
import id.arajangstudio.moviecatalogue.data.DataEntity
import id.arajangstudio.moviecatalogue.databinding.ActivityDetailBinding


class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIEORTVSHOW = "extra_movieortvshow"
    }

    private lateinit var activityDetailBinding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityDetailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(activityDetailBinding.root)
        setSupportActionBar(activityDetailBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        activityDetailBinding.toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        val viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[DetailViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val category = extras.getString("category")
            if (category == "isMovie") {
                val movieId = extras.getString(EXTRA_MOVIEORTVSHOW)
                if (movieId != null) {
                    viewModel.setSelected(movieId)
                    populateMovieorTvshow(viewModel.getMovies() as DataEntity)
                }
            } else {
                val tvShowId = extras.getString(EXTRA_MOVIEORTVSHOW)
                if (tvShowId != null) {
                    viewModel.setSelected(tvShowId)
                    populateMovieorTvshow(viewModel.getTvShow() as DataEntity)
                }
            }
        }

    }

    private fun populateMovieorTvshow(dataEntity: DataEntity) {

        activityDetailBinding.tvDescription.isSelected = true
        activityDetailBinding.tvRating.background.alpha = 128
        activityDetailBinding.tvCategory.background.alpha = 128
        activityDetailBinding.tvTitle.bringToFront()
        activityDetailBinding.collapseTollbar.title = dataEntity.title
        activityDetailBinding.tvTitle.text = dataEntity.title
        activityDetailBinding.tvDescription.text = dataEntity.summary
        activityDetailBinding.tvYear.text = dataEntity.year
        activityDetailBinding.tvCategory.text = dataEntity.category
        activityDetailBinding.tvGenre.text = dataEntity.genre
        activityDetailBinding.tvRating.text = dataEntity.rating

        activityDetailBinding.tvDuration.text =
            baseContext.getString(R.string.duration, dataEntity.lenght)
        activityDetailBinding.tvLanguage.text =
            baseContext.getString(R.string.language, dataEntity.language)


        activityDetailBinding.btnShare.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, dataEntity.url)
            this.startActivity(Intent.createChooser(shareIntent, "Share link using"))
        }

        activityDetailBinding.imgPoster.bringToFront()

        Glide.with(this).load(dataEntity.backDrop)
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error)
            )
            .into(object : CustomTarget<Drawable>() {
                override fun onResourceReady(
                    resource: Drawable,
                    transition: Transition<in Drawable>?
                ) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        activityDetailBinding.imgBackdrop.background = resource
                    }
                }

                override fun onLoadCleared(placeholder: Drawable?) {
                    activityDetailBinding.imgBackdrop.background = placeholder
                }
            })

        Glide.with(this)
            .load(dataEntity.imagePath)
            .transform(RoundedCorners(20))
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error)
            )
            .into(activityDetailBinding.imgPoster)
    }


}