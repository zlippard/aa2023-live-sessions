package com.kodeco.android.aa2023.network

import com.kodeco.android.aa2023.models.Country
import retrofit2.http.GET

interface CountryService {
    @GET("all")
    suspend fun getAllCountries(): List<Country>
}
