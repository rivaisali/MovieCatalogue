package id.arajangstudio.moviecatalogue.ui.tvshow

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class TvshowViewModelTest {

    private lateinit var viewModel: TvshowViewModel

    @Before
    fun setUp() {
        viewModel = TvshowViewModel()
    }

    @Test
    fun getMovies() {
        val tvshowEntities = viewModel.getTvshow()
        Assert.assertNotNull(tvshowEntities)
        Assert.assertEquals(10, tvshowEntities.size)
    }
}