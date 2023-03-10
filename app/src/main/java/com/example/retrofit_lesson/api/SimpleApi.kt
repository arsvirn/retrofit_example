package com.example.retrofit_lesson.api

import com.example.retrofit_lesson.model.Post
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SimpleApi {

    @GET("posts/1")
    suspend fun getPost(): Response<Post>

    @GET("posts/{postNumber}")
    suspend fun getPost2(
        @Path("postNumber") number: Int
    ): Response<Post>

    @GET("posts")
    suspend fun getCustomPosts(
        @Query("userId") userId: Int
    ): Response<List<Post>>

}