package com.example.eni_shop.dao.memory

import com.example.eni_shop.bo.Article
import com.example.eni_shop.dao.ArticleDAO
import java.lang.Exception
import java.util.Date

class ArticleDaoMemoryImpl : ArticleDAO {

    private val articlesInMemory: MutableList<Article> = mutableListOf<Article>(
        Article(
            1,
            "Souris",
            "Souris sans fil",
            10.0,
            "https://m.media-amazon.com/images/I/61-GeOlhtlL._AC_SX679_.jpg",
            Date()
        ),
        Article(2, "Ecran", "Ecran 27\" FULL HD", 780.40, "", Date()),
        Article(3, "Barrete de mémoire vive", "RAM 2 x 16Go", 45.90, "", Date())
    )
    override fun selectById(id: Long): Article? {
        return articlesInMemory.first {article -> article.id == id }
    }

    override fun addNewOne(article: Article): Long {
        articlesInMemory.add(article)
        article.id = articlesInMemory.last().id + 1
        return article.id
    }

    override fun selectAll(): List<Article> {
       return articlesInMemory
    }


}