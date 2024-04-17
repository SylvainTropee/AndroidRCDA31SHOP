package com.example.eni_shop.dao.network

import com.example.eni_shop.bo.Article
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface ApiEniShopService {

    companion object{
        // La racine de l'api
        val BASE_URL = "https://fakestoreapi.com/"

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

    @GET("products")
    suspend fun getArticles() : List<Article>
}