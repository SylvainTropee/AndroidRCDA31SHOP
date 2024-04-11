package com.example.eni_shop.bo

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.Date

@Parcelize
data class Article(
    var id : Long = 0,
    var titre : String = "",
    var description : String = "",
    var prix : Double = 0.0,
    var urlImage : String = "",
    var dateSortie : Date? = Date()
) :Parcelable
