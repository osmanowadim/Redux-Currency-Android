package osmanov.example.mvicurrencyandroid.di

import org.koin.dsl.module
import osmanov.example.mvicurrencyandroid.presentation.main.mvi.MainStore
import osmanov.example.mvicurrencyandroid.storybook.main.loading.FakeLoadingMainStore

val fakeLoadingMainStoreModule = module {
    factory<MainStore> { FakeLoadingMainStore(get()) }
}