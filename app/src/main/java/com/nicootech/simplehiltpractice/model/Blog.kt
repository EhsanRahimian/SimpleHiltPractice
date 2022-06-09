package com.nicootech.simplehiltpractice.model

data class Blog (
    //domain model
    var id :Int,
    var title : String,
    var body : String,
    var image : String,
    var category : String
        )