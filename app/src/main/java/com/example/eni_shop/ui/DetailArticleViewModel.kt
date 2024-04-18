package com.example.eni_shop.ui

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.eni_shop.bo.Article
import com.example.eni_shop.repository.ArticleRepository
import kotlinx.coroutines.launch

class DetailArticleViewModel(_context : Context) : ViewModel() {

    // Un article dont la valeur est écoutable
    var article = MutableLiveData<Article>();

    /**
     * Fonction pour appeler l'API
     */
    fun requestArticle(id: Long) {

        viewModelScope.launch {

            // Notifier que l'article a été récupéré
            article.value = ArticleRepository.getArticle(id);
        }
    }
}