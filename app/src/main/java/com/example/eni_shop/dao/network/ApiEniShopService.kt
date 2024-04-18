package com.example.eni_shop.dao.network

import com.example.eni_shop.bo.Article
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiEniShopService {

    companion object{
        // La racine de l'api
        val BASE_URL = "http://localhost:3000/"

        // L'utilitaire conversion JSON <=> Objet
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build();

        // Retrofit
        val retrofit = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(BASE_URL).build();
    }

    /**
     * Singleton (comme le getInstance sur java dans le cours JEE)
     */
    object Api {
        val retrofitService : ApiEniShopService by lazy { retrofit.create(ApiEniShopService::class.java) }
    }

    @GET("articles")
    suspend fun getArticles() : List<Article>

    @GET("article/{id}")
    suspend fun getArticleById(@Path("id") id : Long) :  Article
}