package com.muskan.myapplication.data.repository

import com.muskan.myapplication.data.local.CountryDao
import com.muskan.myapplication.data.local.CountryEntity
import com.muskan.myapplication.data.local.DatabaseHelper
import com.muskan.myapplication.data.model.CountryAPIDataModel
import com.muskan.myapplication.data.network.ApiService
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import javax.inject.Inject

class MyRepository @Inject constructor(
    private val apiService: ApiService,
    private val databaseHelper: DatabaseHelper
){
    suspend fun fetchData(): Response<CountryAPIDataModel?> {
       val response =  apiService.endpoint()
        response.body()?.let{
            databaseHelper.deleteData()
            databaseHelper.addCountry(it.toCountryEntity())
        }
        return response
    }

    fun getCountryFromDb(): Flow<CountryEntity?> {
        return databaseHelper.getCountry()
    }
}