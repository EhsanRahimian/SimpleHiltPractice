package com.nicootech.simplehiltpractice.di

import com.nicootech.simplehiltpractice.repository.MainRepository
import com.nicootech.simplehiltpractice.retrofit.BlogRetrofitService
import com.nicootech.simplehiltpractice.retrofit.NetworkMapper
import com.nicootech.simplehiltpractice.room.BlogDao
import com.nicootech.simplehiltpractice.room.CacheMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {

    @Singleton
    @Provides
    fun provideMainRepository(
        blogDao: BlogDao,
        retrofit: BlogRetrofitService,
        cacheMapper: CacheMapper,
        networkMapper: NetworkMapper
    ): MainRepository {
        return MainRepository(blogDao, retrofit, cacheMapper, networkMapper)
    }
}