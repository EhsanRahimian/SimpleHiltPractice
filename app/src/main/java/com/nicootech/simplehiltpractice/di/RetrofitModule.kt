package com.nicootech.simplehiltpractice.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.nicootech.simplehiltpractice.retrofit.BlogRetrofitService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RetrofitModule {

    @Singleton
    @Provides
    fun provideGsonBuilder(): Gson {
        return GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create()
    }
    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl("https://open-api.xyz/placeholder/")
            .addConverterFactory(GsonConverterFactory.create(gson))
    }
    @Singleton
    @Provides
    fun provideBlogService(retrofit: Retrofit.Builder): BlogRetrofitService {
        return retrofit
            .build()
            .create(BlogRetrofitService::class.java)
    }

//    @Provides
//    @Singleton
//    fun provideBlogService(): BlogRetrofitService {
//        return Retrofit.Builder()
//            .baseUrl("https://open-api.xyz/placeholder/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//            .create(BlogRetrofitService::class.java)
//    }

}