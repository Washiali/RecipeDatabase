package com.example.mboga


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [Recipe::class],
    version = 1
)
abstract class RecipeDatabase:RoomDatabase() {

    abstract val dao : RecipeDao

    @Volatile
    private var INSTANCE:RoomDatabase? = null

    fun getInstance(context: Context):RoomDatabase {
        return INSTANCE ?: synchronized(this){
            INSTANCE ?: Room.databaseBuilder(
                context.applicationContext,RecipeDatabase::class.java,"recipe_database"
            )
                .fallbackToDestructiveMigration()
                .build()
                .also { INSTANCE = it }
        }
    }

}