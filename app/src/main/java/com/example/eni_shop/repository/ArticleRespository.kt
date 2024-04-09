package com.example.eni_shop.repository

import com.example.eni_shop.bo.Article
import com.example.eni_shop.dao.ArticleDAO
import com.example.eni_shop.dao.DaoFactory
import com.example.eni_shop.dao.DaoType

class ArticleRespository {

    val articleDAO : ArticleDAO = DaoFactory.createArticleDAO(DaoType.MEMORY)

    fun getArticle(id : Long) : Article? {
        return articleDAO.selectById(id)
    }
    fun addArticle(article: Article) : Long{
        return articleDAO.addNewOne(article)
    }

}