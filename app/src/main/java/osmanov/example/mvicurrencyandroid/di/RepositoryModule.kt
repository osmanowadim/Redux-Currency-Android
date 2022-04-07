package osmanov.example.mvicurrencyandroid.di

import org.koin.dsl.module
import osmanov.example.mvicurrencyandroid.data.cache.currency.CurrencyCache
import osmanov.example.mvicurrencyandroid.data.cache.currency.CurrencyCacheContract
import osmanov.example.mvicurrencyandroid.data.mapper.CurrencyEntityMapper
import osmanov.example.mvicurrencyandroid.data.mapper.CurrencyRemoteMapper
import osmanov.example.mvicurrencyandroid.data.repository.CurrencyRepository
import osmanov.example.mvicurrencyandroid.data.repository.CurrencyRepositoryContract

/**
 * Module for Repositories dependency. Like [CurrencyRepositoryContract], [CurrencyCacheContract],
 * [CurrencyEntityMapper], [CurrencyRemoteMapper] ...
 */
val repositoryModule = module {
    single<CurrencyRepositoryContract> { CurrencyRepository(get(), get()) }
    single<CurrencyCacheContract> { CurrencyCache(get(), get()) }
    single { CurrencyEntityMapper() }
    single { CurrencyRemoteMapper() }
}
