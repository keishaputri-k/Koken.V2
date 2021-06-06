package com.kei.kokenv2.data.database.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.kei.kokenv2.model.FoodJoke
import com.kei.kokenv2.util.Constants.Companion.FOOD_JOKE_TABLE

@Entity(tableName = FOOD_JOKE_TABLE)
class FoodJokeEntity(
    //Menandai bidang Entitas atau POJO untuk memungkinkan bidang bertumpuk
    // (yaitu bidang kelas bidang yang dianotasikan) untuk dirujuk langsung di kueri SQL.
    @Embedded
    var foodJoke: FoodJoke
) {
    @PrimaryKey(autoGenerate = false)
    var id: Int = 0
}