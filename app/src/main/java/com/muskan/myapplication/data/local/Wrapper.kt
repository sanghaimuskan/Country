package com.muskan.myapplication.data.local

import kotlinx.coroutines.flow.Flow

interface DatabaseHelper {
    suspend fun addCountry(country: CountryEntity)

    fun getCountry(): Flow<CountryEntity?>

    suspend fun deleteData()
}