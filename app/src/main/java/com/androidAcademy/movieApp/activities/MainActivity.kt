package com.androidAcademy.movieApp.activities

import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.androidAcademy.movieApp.fragments.DetailsFragment
import com.androidAcademy.movieApp.fragments.MovieFragment
import com.androidAcademy.movieApp.R
import com.androidAcademy.movieApp.adapters.SimplePagerAdapter
import com.example.actions.MoviesRVClickListener
import com.example.data_classes.MovieModel

class MainActivity : AppCompatActivity(), MoviesRVClickListener {

    private var tabletFragmentContainer: FrameLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tabletFragmentContainer = findViewById(R.id.activity_main_tablet_frame)

        var moviesFragment = MovieFragment()

        supportFragmentManager
            .beginTransaction()
            .add(R.id.activity_main_frame, moviesFragment)
            .commit()

    }

    override fun onMovieClick(movie: MovieModel) {
        val detailsFragment =
            DetailsFragment.newInstance(
                movie
            )

        if (tabletFragmentContainer == null) {
            //Phone mode
            supportFragmentManager
                .beginTransaction()
                .addToBackStack(null)
                .replace(R.id.activity_main_frame, detailsFragment)
                .commit()
        } else {
            //Tablet mode
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.activity_main_tablet_frame, detailsFragment)
                .commit()
        }

    }

}