package com.androidAcademy.movieApp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.androidAcademy.movieApp.R
import com.example.data_classes.MovieModel

class DetailsFragment: Fragment() {

    private lateinit var posterImage: ImageView
    private lateinit var sidePoster : ImageView
    private lateinit var titleText: TextView
    private lateinit var releaseDateText: TextView
    private lateinit var trailerButton: Button
    private lateinit var overviewText: TextView

    companion object {
        private const val MOVIE_BUNDLE_KEY = "movie_key"

        fun newInstance(movie : MovieModel) : DetailsFragment {
            var fragment =
                DetailsFragment()
            val args = Bundle()
            args.putParcelable(MOVIE_BUNDLE_KEY, movie)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_details, container, false)
        var movie : MovieModel? = arguments?.getParcelable(MOVIE_BUNDLE_KEY)
        initView(view)
        movie?.let(::loadMovie)
        return view
    }

    private fun initView(view : View) {
        posterImage = view.findViewById(R.id.posterImage)
        sidePoster = view.findViewById(R.id.img_side_poster)
        titleText = view.findViewById(R.id.movieTitle)
        releaseDateText = view.findViewById(R.id.release_date)
        trailerButton = view.findViewById(R.id.trailerBtn)
        overviewText = view.findViewById(R.id.movieOverview)
    }

    private fun loadMovie(movie: MovieModel) {
        titleText.text = movie.movieName
        overviewText.text = movie.movieDesc
        sidePoster.setImageResource(movie.movieImage)
    }

}