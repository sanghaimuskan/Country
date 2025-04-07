package com.muskan.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import com.muskan.myapplication.ui.composables.MainScreenUi
import com.muskan.myapplication.viewmodel.MyVM
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MyVM by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val data = viewModel.countriesData.collectAsState()
            MainScreenUi(data.value){
                viewModel.getSomeData()
            }
        }
    }
}

