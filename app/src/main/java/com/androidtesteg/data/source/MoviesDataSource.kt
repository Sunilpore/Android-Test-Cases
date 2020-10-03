package com.androidtesteg.data.source

import com.androidtesteg.data.Movie


interface MoviesDataSource {

    fun getMovie(movieId: Int): Movie?
}