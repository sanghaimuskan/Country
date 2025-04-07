package com.muskan.myapplication.viewmodel

import androidx.lifecycle.ViewModel
import com.muskan.myapplication.data.repository.MyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    private val repo : MyRepository
):ViewModel(){



}