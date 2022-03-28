package com.example.draggerbasic.model

import io.reactivex.rxjava3.core.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

/**
 * Created by PrernaSurbhi on 27/03/22.
 */
class CountryServiceImp {

    @Inject
    lateinit var api:CountriesApi

    init {
           DaggerApiComponent.create().inject(this)
    }

    fun getCountries():Single<List<Country>>{
        return api.getCountries()
    }
}