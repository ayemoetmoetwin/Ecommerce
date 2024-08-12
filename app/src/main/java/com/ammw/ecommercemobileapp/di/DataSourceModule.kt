package com.ammw.ecommercemobileapp.di

import com.ammw.ecommercemobileapp.data.datasource.FirebaseRemoteDataSource
import org.koin.dsl.module

val remoteDataSourceModule = module {
    single {
        FirebaseRemoteDataSource(get())
    }
}
