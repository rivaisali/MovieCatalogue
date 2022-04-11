package id.arajangstudio.moviecatalogue.ui.detail

import androidx.lifecycle.ViewModel
import id.arajangstudio.moviecatalogue.data.DataEntity
import id.arajangstudio.moviecatalogue.utils.DataDummy

class DetailViewModel : ViewModel() {
    private lateinit var Id: String

    fun setSelected(Id: String) {
        this.Id = Id
    }

    fun getMovies(): DataEntity? {
        var movies: DataEntity? = null
        for (dataEntity in DataDummy.generateDummyMovies()) {
            if (dataEntity.id == Id) {
                movies = dataEntity
            }
        }
        return movies
    }


    fun getTvShow(): DataEntity? {
        var tvshow: DataEntity? = null
        for (dataEntity in DataDummy.generateDummyTvshow()) {
            if (dataEntity.id == Id) {
                tvshow = dataEntity
            }
        }
        return tvshow
    }


}