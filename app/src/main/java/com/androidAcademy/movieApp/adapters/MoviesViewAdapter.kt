package com.androidAcademy.movieApp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.androidAcademy.movieApp.R
import com.example.actions.MoviesRVClickListener
import com.example.data_classes.MovieModel
import kotlinx.android.synthetic.main.activity_movie_item.view.*

class MoviesViewAdapter(context : Context, private val onClickListener : MoviesRVClickListener) : RecyclerView.Adapter<MoviesViewAdapter.ViewHolder>() {

    private var movies = mutableListOf<MovieModel>()

    private val layoutInflater : LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = layoutInflater.inflate(R.layout.activity_movie_item, parent,false)
        return ViewHolder(view, onClickListener)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    fun setData(movies : MutableList<MovieModel>) {
        this.movies.clear()
        this.movies = movies
        notifyDataSetChanged()
    }

    inner class ViewHolder(view : View, onClickListener : MoviesRVClickListener) : RecyclerView.ViewHolder(view){

        private val miMovieTitle = view.miMovieTitle
        private val miMovieDesc = view.miMovieDesc
        private val miMovieImage = view.miMovieImage

        init {
            view.setOnClickListener {
                onClickListener.onMovieClick(movies[adapterPosition])
            }
        }

        fun bind(movieDetails : MovieModel) {
            miMovieTitle.text = movieDetails.movieName
            miMovieDesc.text = movieDetails.movieDesc
            miMovieImage.setImageResource(movieDetails.movieImage)
        }

    }

}