package com.muskan.myapplication.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "country")
data class CountryEntity(
    @PrimaryKey(autoGenerate = true) val index: Int = 0,
    val countryName: String? = null,
    val regionName: String? = null,
    val bgColor : Int? = null
)
