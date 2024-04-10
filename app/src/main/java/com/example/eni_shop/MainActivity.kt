package com.example.eni_shop

import android.os.Bundle
import android.text.Editable
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.eni_shop.bo.Article
import com.example.eni_shop.databinding.ActivityMainBinding
import com.example.eni_shop.repository.ArticleRepository
import com.google.android.material.snackbar.Snackbar
import java.text.SimpleDateFormat

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
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