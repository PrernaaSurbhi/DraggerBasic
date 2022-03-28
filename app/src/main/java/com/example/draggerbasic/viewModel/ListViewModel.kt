package com.example.draggerbasic.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.draggerbasic.model.Country
import com.example.draggerbasic.model.CountryServiceImp
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.observers.DisposableSingleObserver
import io.reactivex.rxjava3.schedulers.Schedulers

/**
 * Created by PrernaSurbhi on 26/03/22.
 */
class ListViewModel:ViewModel() {
    val countries = MutableLiveData<List<Country>>()
    val countryLoadError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()
    val disposible = CompositeDisposable()

    val countryServiceImp = CountryServiceImp()

    fun refresh(){
        fetchCountries()
    }

    private fun fetchCountries(){
       loading.postValue(true)

        disposible.add(
            countryServiceImp.getCountries()
                .observeOn(Schedulers.newThread())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object:DisposableSingleObserver<List<Country>>(){
                    override fun onSuccess(value: List<Country>?) {
                        countries.postValue(value)
                        countryLoadError.postValue(false)
                        loading.postValue(false)
                    }

                    override fun onError(e: Throwable?) {
                        countryLoadError.postValue(true)
                        loading.value = false
                    }

                })
        )

    }

    override fun onCleared() {
        super.onCleared()
        disposible.clear()
    }
}