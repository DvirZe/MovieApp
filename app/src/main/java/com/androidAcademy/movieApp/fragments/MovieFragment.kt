package com.androidAcademy.movieApp.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.androidAcademy.movieApp.R
import com.androidAcademy.movieApp.adapters.MoviesViewAdapter
import com.example.actions.MoviesRVClickListener
import com.example.data_classes.MovieModel
import java.util.ArrayList

class MovieFragment : Fragment(), MoviesRVClickListener {

    private var onClickListener : MoviesRVClickListener? = null
    private val moviesList : MutableList<MovieModel> = ArrayList()
    private lateinit var moviesAdapter : MoviesViewAdapter
    private lateinit var moviesRcv : RecyclerView

    companion object {
        val TAG = MovieFragment::class.simpleName
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_movies, container, false)
        moviesRcv = view.findViewById(R.id.movies_fragment_rcv)
        loadMovies()
        initRecyclerView()
        return view
    }

    private fun initRecyclerView() {
        context?.let {
            moviesAdapter =
                MoviesViewAdapter(
                    it,
                    this@MovieFragment
                )

            moviesRcv.layoutManager = LinearLayoutManager(it)

            moviesRcv.adapter = moviesAdapter

            moviesAdapter.setData(moviesList)
        }
    }

    fun loadMovies() : MutableList<MovieModel> {
        moviesList.add(MovieModel("Avengers: Infinity War0",
            "Avengers: Infinity War is a 2018 American superhero film based on the Marvel Comics superhero team the Avengers, produced by Marvel Studios and distributed by Walt Disney Studios Motion Pictures. It is the sequel to 2012s The Avengers and 2015s Avengers: Age of Ultron, and the nineteenth film in the Marvel Cinematic Universe (MCU)."
            , R.drawable.avng_main
        ))
        moviesList.add(MovieModel("Avengers: Infinity War1",
            "Avengers: Infinity War is a 2018 American superhero film based on the Marvel Comics superhero team the Avengers, produced by Marvel Studios and distributed by Walt Disney Studios Motion Pictures. It is the sequel to 2012s The Avengers and 2015s Avengers: Age of Ultron, and the nineteenth film in the Marvel Cinematic Universe (MCU)."
            , R.drawable.avng_main
        ))
        moviesList.add(MovieModel("Avengers: Infinity War2",
            "Avengers: Infinity War is a 2018 American superhero film based on the Marvel Comics superhero team the Avengers, produced by Marvel Studios and distributed by Walt Disney Studios Motion Pictures. It is the sequel to 2012s The Avengers and 2015s Avengers: Age of Ultron, and the nineteenth film in the Marvel Cinematic Universe (MCU)."
            , R.drawable.avng_main
        ))
        moviesList.add(MovieModel("Avengers: Infinity War3",
            "Avengers: Infinity War is a 2018 American superhero film based on the Marvel Comics superhero team the Avengers, produced by Marvel Studios and distributed by Walt Disney Studios Motion Pictures. It is the sequel to 2012s The Avengers and 2015s Avengers: Age of Ultron, and the nineteenth film in the Marvel Cinematic Universe (MCU)."
            , R.drawable.avng_main
        ))
        return moviesList
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is MoviesRVClickListener) {
            onClickListener = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        onClickListener = null
    }

    override fun onMovieClick(movie: MovieModel) {
        onClickListener?.onMovieClick(movie)
    }

    fun getMovieList() : MutableList<MovieModel> = moviesList

}