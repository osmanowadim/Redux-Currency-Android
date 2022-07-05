package osmanov.example.mvicurrencyandroid.di

import org.koin.dsl.module
import osmanov.example.mvicurrencyandroid.presentation.detail.mvi.DetailStore
import osmanov.example.mvicurrencyandroid.presentation.main.mvi.MainStore
import osmanov.example.mvicurrencyandroid.storybook.detail.error.FakeErrorDetailStore
import osmanov.example.mvicurrencyandroid.storybook.detail.success.FakeSuccessDetailStore
import osmanov.example.mvicurrencyandroid.storybook.main.error.FakeErrorMainStore
import osmanov.example.mvicurrencyandroid.storybook.main.loading.FakeLoadingMainStore
import osmanov.example.mvicurrencyandroid.storybook.main.success.FakeSuccessMainStore

val fakeLoadingMainStoreModule = module {
    factory<MainStore> { FakeLoadingMainStore(get()) }
}

val fakeErrorMainStoreModule = module {
    factory<MainStore> { FakeErrorMainStore(get()) }
}

val fakeSuccessMainStoreModule = module {
    factory<MainStore> { FakeSuccessMainStore(get()) }
}

val fakeSuccessDetailStoreModule = module {
    factory<DetailStore> { FakeSuccessDetailStore() }
}

val fakeErrorDetailStoreModule = module {
    factory<DetailStore> { FakeErrorDetailStore() }
}
