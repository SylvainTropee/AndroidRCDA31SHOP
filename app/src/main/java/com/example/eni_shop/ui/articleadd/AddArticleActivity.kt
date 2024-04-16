package com.example.eni_shop.ui.articleadd

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.eni_shop.R
import com.example.eni_shop.bo.Article
import com.example.eni_shop.databinding.ActivityAddArticleBinding
import com.example.eni_shop.repository.ArticleRepository
import com.example.eni_shop.ui.HomeActivity

class AddArticleActivity : AppCompatActivity() {

    lateinit var binding: ActivityAddArticleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_article)

        // binder le view model
        val viewModel = AddArticleViewModel();
        binding.viewModel = viewModel;

        // Ecouter quand un article a été
        viewModel.addSuccess.observe(this, Observer {
            // Si true : donc article ajouté avec succès
            if (it){
                val article = viewModel.article!!

                Intent(this, HomeActivity::class.java).also {
                    it.putExtra("title", article.titre)
                    it.putExtra("price", article.prix.toString())
                    startActivity(it)
                }
            }
        })

        // Quand on appuye sur le bouton
        binding.btnSave.setOnClickListener {
            viewModel.addArticle()
        }
    }
}