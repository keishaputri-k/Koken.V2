package com.kei.kokenv2.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.kei.kokenv2.model.FoodRecipe
import com.kei.kokenv2.util.Constants.Companion.RECIPES_TABLE

@Entity(tableName = RECIPES_TABLE)
class RecipesEntity(
    var foodRecipe: FoodRecipe
) {
    @PrimaryKey(autoGenerate = false)
    var id: Int = 0
}