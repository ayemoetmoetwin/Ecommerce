package com.ammw.ecommercemobileapp.di

import com.ammw.ecommercemobileapp.ui.viewmodel.BookmarkViewModel
import com.ammw.ecommercemobileapp.ui.viewmodel.DetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        BookmarkViewModel(
            get()
        )
    }
    viewModel {
        DetailViewModel(
            get()
        )
    }
}

