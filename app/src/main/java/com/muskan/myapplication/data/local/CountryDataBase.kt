package com.muskan.myapplication.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [CountryEntity::class], version = 1)
abstract class CountryDataBase : RoomDatabase() {
    abstract fun countryDao(): CountryDao

    companion object {
        @Volatile
        private var Instance: CountryDataBase? = null

        fun getDatabase(context: Context): CountryDataBase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    CountryDataBase::class.java,
                    "country_db"
                ).build().also { Instance = it }
            }
        }
    }

}

