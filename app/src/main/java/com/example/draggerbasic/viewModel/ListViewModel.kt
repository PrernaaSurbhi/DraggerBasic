package com.example.draggerbasic.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.draggerbasic.model.Country

/**
 * Created by PrernaSurbhi on 26/03/22.
 */
class ListViewModel:ViewModel() {
    val countries = MutableLiveData<List<Country>>()
    val countryLoadError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

    fun refresh(){
        fetchCountries()
    }

    private fun fetchCountries(){
        val mockData = listOf(
            Country("countryA"),
            Country("countryB"),
            Country("countryC"),
            Country("countryD"),
            Country("countryE"),
            Country("countryF"),
            Country("countryG"),
            Country("countryH"),
            Country("countryI")
        )

        countryLoadError.postValue(false)
        loading.postValue(false)
        countries.postValue(mockData)
    }
}