package com.muskan.myapplication.data.model

import com.google.gson.annotations.SerializedName
import com.muskan.myapplication.data.local.CountryEntity
import com.muskan.myapplication.utils.getCountryBgColor

data class CountryAPIDataModel(
    @SerializedName("data")
    val data: HashMap<String?, CountryRegionDataClass?>? = null,
){
    fun toCountryEntity():CountryEntity{
        val randomCountry = data?.values
            ?.filterNotNull()
            ?.randomOrNull()

        return CountryEntity(
            countryName = randomCountry?.country,
             regionName = randomCountry?.region,
            bgColor = getCountryBgColor(randomCountry?.country)
        )

    }
}

data class CountryRegionDataClass(
    @SerializedName("country")
    val country: String? = null,
    @SerializedName("region")
    val region: String? = null
)