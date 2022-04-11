package id.arajangstudio.moviecatalogue.ui.movie

import androidx.lifecycle.ViewModel
import id.arajangstudio.moviecatalogue.data.DataEntity
import id.arajangstudio.moviecatalogue.utils.DataDummy

class MoviesViewModel : ViewModel() {

    fun getMovies(): List<DataEntity> = DataDummy.generateDummyMovies()
}