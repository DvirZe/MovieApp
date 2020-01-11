package com.example.data_classes

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieModel(val movieName : String,
                      val movieDesc : String,
                      @DrawableRes val movieImage : Int) : Parcelable