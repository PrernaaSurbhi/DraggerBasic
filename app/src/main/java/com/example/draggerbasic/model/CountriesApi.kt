package com.example.draggerbasic.model

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

/**
 * Created by PrernaSurbhi on 27/03/22.
 */
interface CountriesApi {
    @GET("DevTides/countries/master/countriesV2.json")
    fun getCountries():Single<List<Country>>
}