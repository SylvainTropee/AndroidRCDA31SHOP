package com.example.eni_shop.utils

import java.text.SimpleDateFormat
import java.util.Date

object Converter {

    val format = SimpleDateFormat("dd/MM/yyy")

    @JvmStatic
    fun dateToString(date: Date?): String {
        return format.format(date)
    }
}