package com.nicootech.simplehiltpractice.repository

import com.nicootech.simplehiltpractice.model.Blog
import com.nicootech.simplehiltpractice.retrofit.BlogRetrofitService
import com.nicootech.simplehiltpractice.retrofit.NetworkMapper
import com.nicootech.simplehiltpractice.room.BlogDao
import com.nicootech.simplehiltpractice.room.CacheMapper
import com.nicootech.simplehiltpractice.util.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class MainRepository(
    private val blogDao: BlogDao,
    private val blogRetrofitService: BlogRetrofitService,
    private val cacheMapper: CacheMapper,
    private val networkMapper: NetworkMapper
) {
    suspend fun getBlogs(): Flow<DataState<List<Blog>>> = flow {
        emit(DataState.Loading)
        try {
            val networkBlogs = blogRetrofitService.get()
            val blogs = networkMapper.mapFromEntityList(networkBlogs)
            for (blog in blogs) {
                blogDao.insert(cacheMapper.mapFromDomainModelToEntity(blog))
            }
            val cachedBlogs = blogDao.get()
            emit(DataState.Success(cacheMapper.mapFromEntityList(cachedBlogs)))
        } catch (e: Exception) {
            emit(DataState.Error(e))
        }

    }
}