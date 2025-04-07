package com.muskan.myapplication.data.network

import com.muskan.myapplication.data.model.CountryAPIDataModel
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService{

    @GET("countries")
    suspend fun endpoint(): Response<CountryAPIDataModel?>
}