package id.arajangstudio.moviecatalogue.ui.detail

import id.arajangstudio.moviecatalogue.utils.DataDummy
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class DetailViewModelTest {

    private lateinit var viewModel: DetailViewModel
    private val dummyMovies = DataDummy.generateDummyMovies()[0]
    private val dummyTvshow = DataDummy.generateDummyTvshow()[0]
    private val moviesId = dummyMovies.id
    private val tvshowId = dummyTvshow.id

    @Before
    fun setUp() {
        viewModel = DetailViewModel()
        viewModel.setSelected(moviesId)
        viewModel.setSelected(tvshowId)
    }

    @Test
    fun getMovies() {
        viewModel.setSelected(dummyMovies.id)
        val moviesEntity = viewModel.getMovies()
        assertNotNull(moviesEntity)
        assertEquals(dummyMovies.id, moviesEntity!!.id)
        assertEquals(dummyMovies.title, moviesEntity.title)
        assertEquals(dummyMovies.rating, moviesEntity.rating)
        assertEquals(dummyMovies.genre, moviesEntity.genre)
        assertEquals(dummyMovies.summary, moviesEntity.summary)
        assertEquals(dummyMovies.language, moviesEntity.language)
        assertEquals(dummyMovies.year, moviesEntity.year)
        assertEquals(dummyMovies.lenght, moviesEntity.lenght)
        assertEquals(dummyMovies.url, moviesEntity.url)
        assertEquals(dummyMovies.category, moviesEntity.category)
        assertEquals(dummyMovies.backDrop, moviesEntity.backDrop)
        assertEquals(dummyMovies.imagePath, moviesEntity.imagePath)
    }

    @Test
    fun getTvShow() {
        viewModel.setSelected(dummyTvshow.id)
        val tvShowEntity = viewModel.getTvShow()
        assertNotNull(tvShowEntity)
        assertEquals(dummyTvshow.id, tvShowEntity!!.id)
        assertEquals(dummyTvshow.title, tvShowEntity.title)
        assertEquals(dummyTvshow.rating, tvShowEntity.rating)
        assertEquals(dummyTvshow.genre, tvShowEntity.genre)
        assertEquals(dummyTvshow.summary, tvShowEntity.summary)
        assertEquals(dummyTvshow.language, tvShowEntity.language)
        assertEquals(dummyTvshow.year, tvShowEntity.year)
        assertEquals(dummyTvshow.lenght, tvShowEntity.lenght)
        assertEquals(dummyTvshow.url, tvShowEntity.url)
        assertEquals(dummyTvshow.category, tvShowEntity.category)
        assertEquals(dummyTvshow.backDrop, tvShowEntity.backDrop)
        assertEquals(dummyTvshow.imagePath, tvShowEntity.imagePath)

    }
}