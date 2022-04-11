package id.arajangstudio.moviecatalogue.ui.tvshow

import androidx.lifecycle.ViewModel
import id.arajangstudio.moviecatalogue.data.DataEntity
import id.arajangstudio.moviecatalogue.utils.DataDummy

class TvshowViewModel : ViewModel() {

    fun getTvshow(): List<DataEntity> = DataDummy.generateDummyTvshow()
}