package com.muskan.myapplication.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CountryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCountry(country: CountryEntity)

    @Query("SELECT * FROM country LIMIT 1")
    suspend fun getCountry(): CountryEntity?
}
