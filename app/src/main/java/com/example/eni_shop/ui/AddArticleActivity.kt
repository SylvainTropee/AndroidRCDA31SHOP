package com.example.eni_shop.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.eni_shop.R
import com.example.eni_shop.bo.Article
import com.example.eni_shop.databinding.ActivityAddArticleBinding
import com.example.eni_shop.repository.ArticleRepository
import com.google.android.material.snackbar.Snackbar

class AddArticleActivity : AppCompatActivity() {

    lateinit var binding: ActivityAddArticleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_article)
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)

        //binding.article = article
        binding.article = Article()

        binding.btnSave.setOnClickListener {
            val article = binding.article
            ArticleRepository.addArticle(article!!)

            Intent(this, HomeActivity::class.java).also {
                it.putExtra("title", article.titre)
                it.putExtra("price", article.prix.toString())
                startActivity(it)
            }
        }
    }
}