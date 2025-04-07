package com.muskan.myapplication.data.repository

import com.muskan.myapplication.data.network.ApiService
import javax.inject.Inject

class MyRepository @Inject constructor(
    private val apiService: ApiService,
){}