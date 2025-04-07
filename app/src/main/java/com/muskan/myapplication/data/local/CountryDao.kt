package com.muskan.myapplication.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CountryDao : DatabaseHelper{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    override suspend fun addCountry(country: CountryEntity)

    @Query("SELECT * FROM country LIMIT 1")
    override fun getCountry(): Flow<CountryEntity?>

    @Query("DELETE FROM country")
    override suspend fun deleteData()
}
