package com.example.actions

import android.widget.Toast
import com.example.data_classes.MovieModel

interface MoviesRVClickListener {
    fun onMovieClick(movie : MovieModel)
}