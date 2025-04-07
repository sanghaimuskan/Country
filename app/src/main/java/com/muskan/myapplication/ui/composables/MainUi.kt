package com.muskan.myapplication.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.muskan.myapplication.data.local.CountryEntity

@Composable
fun MainScreenUi(data: CountryEntity?, callApi:()->Unit) {
    MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = data?.bgColor?.let { Color(it) } ?: Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = data?.countryName ?: "Country")
            Text(text = data?.regionName ?: "Region")
            Button(onClick = {
                callApi()
            }) {
                Text(text = "Next Call")
            }
        }
    }
}

