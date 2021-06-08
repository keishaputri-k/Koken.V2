package com.kei.kokenv2.di

import android.content.Context
import androidx.room.Room
import com.kei.kokenv2.data.database.RecipesDatabase
import com.kei.kokenv2.util.Constants.Companion.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton
////Membuat anotasi kelas yang berkontribusi pada grafik objek.
@Module
////Anotasi yang menyatakan komponen mana yang harus disertakan dalam kelas anotasi saat Hilt
//// menghasilkan komponen. Ini hanya dapat digunakan dengan kelas yang dianotasikan dengan
//// @Module atau @EntryPoint.
@InstallIn(ApplicationComponent::class)
object DatabaseModule {
    // Singleton merupakan sebuah obyek atau class pada bahasa pemrograman berbasis Object Oriented
// Programming. Class ini hanya dapat memiliki satu buah instance selama program berjalan.
// Kita tidak diperbolehkan membuat class secara langsung melalui keyword new, dan hanya bisa
// mengakses melalui instance yang telah disediakan
    @Singleton
    //Membuat anotasi metode modul untuk membuat pengikatan metode penyedia.
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        RecipesDatabase::class.java,
        DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun provideDao(database: RecipesDatabase) = database.recipesDao()

}