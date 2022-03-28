package com.example.draggerbasic.model

import com.example.draggerbasic.di.ApiModule
import dagger.Component

/**
 * Created by PrernaSurbhi on 28/03/22.
 */
@Component(modules = [ApiModule::class])
interface ApiComponent {

    fun inject(service:CountryServiceImp)
}