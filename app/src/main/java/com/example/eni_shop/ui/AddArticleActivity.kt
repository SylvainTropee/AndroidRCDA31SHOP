package com.example.eni_shop.ui

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

        val article = ArticleRepository.getArticle(2)
        //binding.article = article
        binding.article = Article()
        binding.btnSave.setOnClickListener {

            Snackbar.make(
                it,
                "Vous venez de créér ${binding.article?.titre} pour un montant de ${binding.article?.prix} €",
                Snackbar.LENGTH_LONG
            ).show()
        }
    }
}