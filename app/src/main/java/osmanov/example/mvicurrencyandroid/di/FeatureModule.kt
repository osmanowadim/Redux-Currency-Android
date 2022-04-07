package osmanov.example.mvicurrencyandroid.di

import org.koin.dsl.module
import osmanov.example.mvicurrencyandroid.presentation.detail.mvi.DetailStore
import osmanov.example.mvicurrencyandroid.presentation.detail.ui.DetailViewModel
import osmanov.example.mvicurrencyandroid.presentation.main.mvi.MainStore
import osmanov.example.mvicurrencyandroid.presentation.main.ui.MainViewModel

/**
 * Module for features. Like Main Screen, Detail Screen ...
 */
val mainModule = module {
    factory { MainStore(get()) }
    factory { MainViewModel(get()) }
}

val detailModule = module {
    factory { DetailStore() }
    factory { DetailViewModel(get()) }
}

val featureModules = arrayOf(
    mainModule,
    detailModule
)
