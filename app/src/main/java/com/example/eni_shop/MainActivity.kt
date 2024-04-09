package com.example.eni_shop

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.eni_shop.repository.ArticleRepository

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var article = ArticleRepository.getArticle(2)
        Log.i(TAG, article.toString())

    }
}