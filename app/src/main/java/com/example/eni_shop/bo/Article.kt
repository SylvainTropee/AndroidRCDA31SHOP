package com.example.eni_shop.bo

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize
import java.util.Date

@Parcelize
data class Article(
    var id : Long = 0,
    @Json(name = "title")
    var titre : String = "",
    var description : String = "",
    @Json(name = "price")
    var prix : Double = 0.0,
    @Json(name = "image")
    var urlImage : String = "",
    @Transient
    var dateSortie : Date? = Date()
) :Parcelable
