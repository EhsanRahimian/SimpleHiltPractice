package com.nicootech.simplehiltpractice.room

import com.nicootech.simplehiltpractice.model.Blog
import com.nicootech.simplehiltpractice.retrofit.BlogNetworkEntity
import com.nicootech.simplehiltpractice.util.EntityMapper
import javax.inject.Inject

class CacheMapper
@Inject
constructor():
EntityMapper<BlogCacheEntity, Blog>{

    override fun mapFromEntityToDomainModel(entity: BlogCacheEntity): Blog {
        return Blog(
            id = entity.id,
            title = entity.title,
            body = entity.body,
            image = entity.image,
            category = entity.category
        )
    }

    override fun mapFromDomainModelToEntity(domainModel: Blog): BlogCacheEntity {
        return BlogCacheEntity(
            id = domainModel.id,
            title = domainModel.title,
            body = domainModel.body,
            image = domainModel.image,
            category = domainModel.category

        )
    }
    fun mapFromEntityList(entities: List<BlogCacheEntity>): List<Blog>{
        return entities.map { mapFromEntityToDomainModel(it) }
    }
}