package osmanov.example.mvicurrencyandroid.di

import org.koin.dsl.module
import osmanov.example.mvicurrencyandroid.presentation.detail.mvi.DetailStore
import osmanov.example.mvicurrencyandroid.presentation.detail.ui.DetailViewModel
import osmanov.example.mvicurrencyandroid.presentation.main.mvi.MainStore
import osmanov.example.mvicurrencyandroid.presentation.main.ui.MainViewModel

/**
 * Module for features. Like Main Screen, Detail Screen ...
 */
val mainStoreModule = module {
    factory { MainStore(get()) }
}
val mainViewModule = module {
    factory { MainViewModel(get()) }
}
val detailStoreModule = module {
    factory { DetailStore() }
}
val detailViewModule = module {
    factory { DetailViewModel(get()) }
}

val featureModules = arrayOf(
    mainStoreModule,
    mainViewModule,
    detailStoreModule,
    detailViewModule
)
