package com.example.eni_shop.ui.articlelist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.eni_shop.bo.Article
import com.example.eni_shop.repository.ArticleRepository

class ListArticleViewModel : ViewModel() {

    var articles = MutableLiveData<List<Article>>()

    fun syncArticles() {
        articles.value = ArticleRepository.getAllArticles()
    }
}