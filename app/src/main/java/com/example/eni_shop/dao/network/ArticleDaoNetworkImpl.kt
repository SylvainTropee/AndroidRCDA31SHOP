package com.example.eni_shop.dao.network

import com.example.eni_shop.bo.Article
import com.example.eni_shop.dao.ArticleDAO

class ArticleDaoNetworkImpl : ArticleDAO {
    override suspend fun selectById(id: Long): Article? {
        return ApiEniShopService.Api.retrofitService.getArticleById(id);
    }

    override suspend fun addNewOne(article: Article): Long {
        TODO("Not yet implemented")
    }

    override suspend fun selectAll(): List<Article> {
        return ApiEniShopService.Api.retrofitService.getArticles()
    }
}