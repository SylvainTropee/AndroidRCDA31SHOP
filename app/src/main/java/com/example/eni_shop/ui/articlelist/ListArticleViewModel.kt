package com.example.eni_shop.ui.articlelist

import android.app.ProgressDialog
import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.eni_shop.bo.Article
import com.example.eni_shop.repository.ArticleRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ListArticleViewModel(val _context : Context) : ViewModel() {

    var articles = MutableLiveData<List<Article>>()

    fun syncArticles() {
        // Afficher un ecran de chargement avec une tâche async
        val progressDialog = ProgressDialog(_context)
        progressDialog.setTitle("Chargement")
        progressDialog.setMessage("Récupération des articles en cours...")
        progressDialog.show();

        // Tâche asynchrone
        viewModelScope.launch {
            // Simuler 1 seconde de lag pour avoir le temps voir l'animation
            delay(1000)

            articles.value = ArticleRepository.getAllArticles()

            // Tâche terminé (donc fermer la modal de chargement)
            progressDialog.dismiss()
        }
    }
}