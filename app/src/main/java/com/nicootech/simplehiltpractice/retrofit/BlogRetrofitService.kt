package com.nicootech.simplehiltpractice.retrofit

import retrofit2.http.GET

interface BlogRetrofitService {

    @GET("blogs")
    suspend fun get(): List<BlogNetworkEntity>
}