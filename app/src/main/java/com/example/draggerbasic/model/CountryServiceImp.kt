package com.example.draggerbasic.model

import io.reactivex.rxjava3.core.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by PrernaSurbhi on 27/03/22.
 */
class CountryServiceImp {
    private val BASE_URL ="https://raw.githubusercontent.com"

    private val api:CountriesApi


    init {
        val rxAdapter = RxJava3CallAdapterFactory.create()
        api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(rxAdapter)
            .build()
            .create(CountriesApi::class.java)
    }

    fun getCountries():Single<List<Country>>{
        return api.getCountries()
    }
}