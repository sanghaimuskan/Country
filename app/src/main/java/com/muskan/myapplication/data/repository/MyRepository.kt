package com.muskan.myapplication.data.repository

import com.muskan.myapplication.data.local.CountryDao
import com.muskan.myapplication.data.local.CountryEntity
import com.muskan.myapplication.data.model.CountryAPIDataModel
import com.muskan.myapplication.data.network.ApiService
import retrofit2.Response
import javax.inject.Inject

class MyRepository @Inject constructor(
    private val apiService: ApiService,
    private val countryDao: CountryDao
){
    suspend fun fetchData(): Response<CountryAPIDataModel?> {
        apiService.endpoint().body()?.let{
            countryDao.addCountry(it.toCountryEntity())
        }
        return apiService.endpoint()
    }

    suspend fun getCountryFromDb():CountryEntity?{
        return countryDao.getCountry()
    }
}