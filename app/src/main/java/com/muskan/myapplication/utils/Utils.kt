package com.muskan.myapplication.utils

import kotlinx.coroutines.CoroutineExceptionHandler

val handler = CoroutineExceptionHandler { _, exception ->
    println("CoroutineExceptionHandler got $exception")
}


fun getCountryBgColor(countryName:String?):Int{
    return when{
        countryName?.contains(char ='o', ignoreCase = true) == true -> 0xFF2196F3.toInt()
        else -> 0xFFFFEB3B.toInt()
    }
}

