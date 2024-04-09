package com.example.eni_shop.dao.memory

import com.example.eni_shop.bo.Article
import com.example.eni_shop.dao.ArticleDAO
import java.lang.Exception

class ArticleDaoMemoryImpl : ArticleDAO {

    private val articlesInMemory: MutableList<Article> = mutableListOf<Article>(
        Article(
            1,
            "Souris",
            "Souris sans fil",
            10.0,
            "https://m.media-amazon.com/images/I/61-GeOlhtlL._AC_SX679_.jpg",
            null
        ),
        Article(2, "Ecran", "Ecran 27\" FULL HD", 780.40, "", null),
        Article(3, "Barrete de mémoire vive", "RAM 2 x 16Go", 45.90, "", null)
    )
    override fun selectById(id: Long): Article? {
        return articlesInMemory.first {article -> article.id == id }
    }

    override fun addNewOne(article: Article): Long {
        articlesInMemory.add(article)
        article.id = articlesInMemory.last().id + 1
        return article.id
    }


}