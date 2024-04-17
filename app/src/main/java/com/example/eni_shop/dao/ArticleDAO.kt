package com.example.eni_shop.dao

import com.example.eni_shop.bo.Article

interface ArticleDAO {

    suspend fun selectById(id : Long) : Article?

    suspend fun addNewOne(article: Article) : Long

    suspend fun selectAll() : List<Article>

}