package id.arajangstudio.moviecatalogue.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import id.arajangstudio.moviecatalogue.R
import id.arajangstudio.moviecatalogue.utils.DataDummy
import org.junit.Rule
import org.junit.Test

class HomeActivityTest {

    private val dummyMovies = DataDummy.generateDummyMovies()
    private val dummyTvShow = DataDummy.generateDummyTvshow()

    @get:Rule
    var activityRule = ActivityScenarioRule(HomeActivity::class.java)

    @Test
    fun loadMovies() {
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovies.size))
    }


    @Test
    fun loadDetailMovies() {
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.imgBackdrop)).check(matches(isDisplayed()))
        onView(withId(R.id.imgPoster)).check(matches(isDisplayed()))
        onView(withId(R.id.collapseTollbar)).check(matches(isDisplayed()))
        onView(withId(R.id.collapseTollbar)).check(matches(withContentDescription(dummyMovies[0].title)))
        onView(withId(R.id.tvTitle)).check(matches(isDisplayed()))
        onView(withId(R.id.tvTitle)).check(matches(withText(dummyMovies[0].title)))
        onView(withId(R.id.tvYear)).check(matches(isDisplayed()))
        onView(withId(R.id.tvYear)).check(matches(withText(dummyMovies[0].year)))
        onView(withId(R.id.tvCategory)).check(matches(isDisplayed()))
        onView(withId(R.id.tvCategory)).check(matches(withText(dummyMovies[0].category)))
        onView(withId(R.id.tvRating)).check(matches(isDisplayed()))
        onView(withId(R.id.tvRating)).check(matches(withText(dummyMovies[0].rating)))
        onView(withId(R.id.tvDuration)).check(matches(isDisplayed()))
        onView(withId(R.id.tvLanguage)).check(matches(isDisplayed()))
        onView(withId(R.id.tvGenre)).check(matches(isDisplayed()))
        onView(withId(R.id.tvGenre)).check(matches(withText(dummyMovies[0].genre)))
        onView(withId(R.id.tvDescription)).check(matches(isDisplayed()))
        onView(withId(R.id.tvDescription)).check(matches(withText(dummyMovies[0].summary)))
        onView(withId(R.id.btnShare)).check(matches(isDisplayed()))
        onView(withId(R.id.btnBookmark)).check(matches(isDisplayed()))
        onView(withId(R.id.btnBookmark)).perform(click())

    }

    @Test
    fun loadTvShow() {
        onView(withText(R.string.tvshow)).perform(click())
        onView(withId(R.id.rv_tvshow)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvshow)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvShow.size))
    }


    @Test
    fun loadDetailTvShow() {
        onView(withText(R.string.tvshow)).perform(click())
        onView(withId(R.id.rv_tvshow)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(4, click()))
        onView(withId(R.id.imgBackdrop)).check(matches(isDisplayed()))
        onView(withId(R.id.imgPoster)).check(matches(isDisplayed()))
        onView(withId(R.id.collapseTollbar)).check(matches(isDisplayed()))
        onView(withId(R.id.collapseTollbar)).check(matches(withContentDescription(dummyTvShow[4].title)))
        onView(withId(R.id.tvTitle)).check(matches(isDisplayed()))
        onView(withId(R.id.tvTitle)).check(matches(withText(dummyTvShow[4].title)))
        onView(withId(R.id.tvYear)).check(matches(isDisplayed()))
        onView(withId(R.id.tvYear)).check(matches(withText(dummyTvShow[4].year)))
        onView(withId(R.id.tvCategory)).check(matches(isDisplayed()))
        onView(withId(R.id.tvCategory)).check(matches(withText(dummyTvShow[4].category)))
        onView(withId(R.id.tvRating)).check(matches(isDisplayed()))
        onView(withId(R.id.tvRating)).check(matches(withText(dummyTvShow[4].rating)))
        onView(withId(R.id.tvDuration)).check(matches(isDisplayed()))
        onView(withId(R.id.tvLanguage)).check(matches(isDisplayed()))
        onView(withId(R.id.tvGenre)).check(matches(isDisplayed()))
        onView(withId(R.id.tvGenre)).check(matches(withText(dummyTvShow[4].genre)))
        onView(withId(R.id.tvDescription)).check(matches(isDisplayed()))
        onView(withId(R.id.tvDescription)).check(matches(withText(dummyTvShow[4].summary)))
        onView(withId(R.id.btnShare)).check(matches(isDisplayed()))
        onView(withId(R.id.btnBookmark)).check(matches(isDisplayed()))
        onView(withId(R.id.btnBookmark)).perform(click())
    }




}