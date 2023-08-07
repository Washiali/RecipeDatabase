package com.example.mboga

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface RecipeDao {
    @Query("SELECT * FROM Recipe")
    fun getAll():Array<Recipe>
    @Insert
    suspend fun insertRecipe(recipe: Recipe)
    @Update
    suspend fun updateRecipe(recipe: Recipe)
    @Delete
    suspend fun deleteRecipe(recipe: Recipe)

    @Query("SELECT * FROM Recipe")
    fun getRecipeByName(name:String):LiveData<Recipe>

    @Query("SELECT * FROM Recipe")
    fun getRecipeByTime(time:String):LiveData<Recipe>

    @Query("SELECT * FROM Recipe")
    fun getRecipeByIngredients(ingredients:Int):LiveData<Recipe>

    @Query("SELECT * FROM Recipe")
    fun getRecipeByDesc(desc:Int):LiveData<Recipe>

    @Query("SELECT * FROM Recipe")
    fun getRecipeByImage(image:Int):LiveData<Recipe>
}

