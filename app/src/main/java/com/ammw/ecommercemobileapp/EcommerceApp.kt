package com.ammw.ecommercemobileapp

import android.app.Application
import com.ammw.ecommercemobileapp.di.networkModule
import com.ammw.ecommercemobileapp.di.remoteDataSourceModule
import com.ammw.ecommercemobileapp.di.repositoryModule
import com.ammw.ecommercemobileapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class EcommerceApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                viewModelModule,
                networkModule,
                repositoryModule,
                remoteDataSourceModule
            )
            androidContext(this@EcommerceApp)
        }
    }
}