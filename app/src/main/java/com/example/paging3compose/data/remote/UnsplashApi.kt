package com.example.paging3compose.data.remote

import com.example.paging3compose.BuildConfig
import com.example.paging3compose.model.SearchResult
import com.example.paging3compose.model.UnsplashImage
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

/**
 * Created by Nicola Luigi Piriottu on 18/07/22.
 */
interface UnsplashApi {

    @Headers("Authorization: Client-ID ${BuildConfig.API_KEY}")
    @GET("/photos")
    suspend fun getAllImages(
        @Query("page") page:Int,
        @Query("per_page") perPage:Int
    ): List<UnsplashImage>


    @Headers("Authorization: Client-ID ${BuildConfig.API_KEY}")
    @GET("/search/photos")
    suspend fun searchImages(
        @Query("query") query:String,
        @Query("per_page") perPage:Int
    ): SearchResult
}