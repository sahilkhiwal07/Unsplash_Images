package com.example.unsplashimages.LoadImages

import com.example.unsplashimages.Model.Images
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

//https://api.unsplash.com/search/photos?client_id=upjc8Q0QCOX3S1gxpNbDRt5fe7ovrx1Gk1GjWRk9jUU&query=travelling&page=1&order_by=latest

const val BASE_URL = "https://api.unsplash.com/"

interface LoadImages {

    @GET("search/photos")
    suspend fun getAllImages(
        @Query("client_id") client_id: String,
        @Query("query") query: String,
        @Query("page") page: Int,
        @Query("order_by") order_by: String,
    )
            : Response<Images>
}

object ImageService {

    var instance: LoadImages

    init {
        var retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        instance = retrofit.create(LoadImages::class.java)
    }

}