package com.nicootech.simplehiltpractice.util

interface EntityMapper<Entity,DomainModel> {
    fun mapFromEntityToDomainModel(entity: Entity):DomainModel
    fun mapFromDomainModelToEntity(domainModel: DomainModel):Entity
}