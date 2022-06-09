package com.nicootech.simplehiltpractice.retrofit

import com.nicootech.simplehiltpractice.model.Blog
import com.nicootech.simplehiltpractice.util.EntityMapper
import javax.inject.Inject

class NetworkMapper
@Inject
constructor():EntityMapper<BlogNetworkEntity,Blog>{


    override fun mapFromEntityToDomainModel(entity: BlogNetworkEntity): Blog {
        return Blog(
            id = entity.id,
            title = entity.title,
            body = entity.body,
            image = entity.image,
            category = entity.category
        )
    }

    override fun mapFromDomainModelToEntity(domainModel: Blog): BlogNetworkEntity {
        return BlogNetworkEntity(
            id = domainModel.id,
            title = domainModel.title,
            body = domainModel.body,
            image = domainModel.image,
            category = domainModel.category
        )
    }

    fun mapFromEntityList(entities: List<BlogNetworkEntity>):List<Blog>{
        return entities.map { mapFromEntityToDomainModel(it) }
    }

}