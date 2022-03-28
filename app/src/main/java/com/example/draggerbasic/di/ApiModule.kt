package com.example.draggerbasic.di

import com.example.draggerbasic.model.CountriesApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by PrernaSurbhi on 28/03/22.
 */

@Module
class ApiModule {
    private val BASE_URL ="https://raw.githubusercontent.com"

    @Provides
    fun provideCountryApi(): CountriesApi{
        val rxAdapter = RxJava3CallAdapterFactory.create()
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(rxAdapter)
            .build()
            .create(CountriesApi::class.java)
    }

}