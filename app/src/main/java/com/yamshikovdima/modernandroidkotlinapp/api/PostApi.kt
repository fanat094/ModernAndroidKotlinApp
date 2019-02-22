package com.yamshikovdima.modernandroidkotlinapp.api

import com.yamshikovdima.modernandroidkotlinapp.model.Post
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET

interface PostApi {

    @GET("/posts")
    fun getPosts(): Single<List<Post>>

    @GET("/posts")
    fun getPostsRx(): Single<List<Post>>
}