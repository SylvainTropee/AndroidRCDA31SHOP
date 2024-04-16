package com.example.eni_shop.ui.articleadd

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.eni_shop.bo.Article
import com.example.eni_shop.repository.ArticleRepository

class AddArticleViewModel : ViewModel() {

    /**
     * Pour savoir si l'article a été ajouté
     * Quand sera vrai alors notify que l'article a été ajouté
     */
    var addSuccess = MutableLiveData<Boolean>(false);

    var article = Article()

    fun addArticle(){
        // Ajouter l'article dans la DAO
        ArticleRepository.addArticle(article)

        // Notifier que l'article a été ajouté
        // PS : va enclencher l'event it = true
        addSuccess.value = true;
    }
}