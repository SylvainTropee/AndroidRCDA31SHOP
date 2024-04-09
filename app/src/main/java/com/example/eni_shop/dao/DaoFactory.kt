package com.example.eni_shop.dao

import com.example.eni_shop.dao.memory.ArticleDaoMemoryImpl
import com.example.eni_shop.dao.network.ArticleDaoNetworkImpl

abstract class DaoFactory {

    companion object{
        fun createArticleDAO(type: DaoType) : ArticleDAO {

            return when(type){
                DaoType.MEMORY -> ArticleDaoMemoryImpl()
                DaoType.NETWORK -> ArticleDaoNetworkImpl()
            }

        }

    }




}