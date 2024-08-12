package com.ammw.ecommercemobileapp.di

import com.ammw.ecommercemobileapp.data.service.FirebaseService
import org.koin.dsl.module

val networkModule = module {
    single {
        FirebaseService(
        )
    }
}




