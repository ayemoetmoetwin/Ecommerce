package com.ammw.ecommercemobileapp.di

import com.ammw.ecommercemobileapp.data.repository.FirebaseRepository
import org.koin.dsl.module

val repositoryModule = module {
    single {
        FirebaseRepository(get())
    }
}