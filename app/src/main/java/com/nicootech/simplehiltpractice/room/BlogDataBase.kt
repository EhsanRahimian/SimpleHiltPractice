package com.nicootech.simplehiltpractice.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [BlogCacheEntity::class], version = 1)
abstract class BlogDataBase: RoomDatabase() {

    abstract fun blogDao(): BlogDao

    companion object{
        val DATABASE_NAME: String = "blog_db"
    }

}