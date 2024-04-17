package com.example.eni_shop.repository

import com.example.eni_shop.bo.Article
import com.example.eni_shop.dao.ArticleDAO
import com.example.eni_shop.dao.DaoFactory
import com.example.eni_shop.dao.DaoType

object ArticleRepository {

    val articleDAO : ArticleDAO = DaoFactory.createArticleDAO(DaoType.NETWORK)

    suspend fun getArticle(id : Long) : Article? {
        return articleDAO.selectById(id)
    }
    suspend fun addArticle(article: Article) : Long{
        return articleDAO.addNewOne(article)
    }
    suspend fun getAllArticles(): List<Article> {
        return articleDAO.selectAll()
    }

}