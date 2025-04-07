package com.muskan.myapplication.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.muskan.myapplication.data.local.CountryEntity
import com.muskan.myapplication.data.repository.MyRepository
import com.muskan.myapplication.utils.handler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyVM @Inject constructor(
    private val repo : MyRepository
):ViewModel(){

    private var _countriesData =  MutableStateFlow<CountryEntity?>(CountryEntity())
    val countriesData = _countriesData.asStateFlow()

    init{
        viewModelScope.launch(Dispatchers.IO) {
            _countriesData.value = repo.getCountryFromDb()
        }

        getSomeData()
    }

    fun getSomeData(){
        viewModelScope.launch(Dispatchers.IO + handler){
            try {
                delay(2000)
                val result = repo.fetchData()
                if (result.isSuccessful) {
                    _countriesData.value = result.body()?.toCountryEntity()
                } else {
                    Log.e("muskan", "API Error: $result")
                }
            }catch(ex:Exception) {
                Log.d("muskan", "getSomeData: $ex")
            }
        }
    }



}