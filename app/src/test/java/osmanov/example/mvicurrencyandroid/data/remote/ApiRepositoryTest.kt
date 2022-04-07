package osmanov.example.mvicurrencyandroid.data.remote

import com.nhaarman.mockito_kotlin.*
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.dsl.module
import org.koin.test.AutoCloseKoinTest
import org.koin.test.inject
import osmanov.example.mvicurrencyandroid.data.mapper.CurrencyRemoteMapper
import osmanov.example.mvicurrencyandroid.data.remote.model.ExchangeResponse
import osmanov.example.mvicurrencyandroid.data.remote.service.ApiService
import osmanov.example.mvicurrencyandroid.di.appModule

class ApiRepositoryTest : AutoCloseKoinTest() {

    private val apiService: ApiService = mock()
    private val currencyMapper: CurrencyRemoteMapper = mock()
    private val apiRepository: ApiRepositoryContract by inject()

    @Before
    fun setUp() {
        startKoin {
            modules(listOf(appModule, module {
                single<ApiRepositoryContract> { ApiRepository(apiService, currencyMapper) }
            }))
        }
    }

    @Suppress("DeferredResultUnused")
    @Test
    fun getCurrenciesMustCallServiceMethod() = runBlocking {
        whenever(apiService.getCurrenciesAsync()).thenReturn(async { ExchangeResponse() })

        apiRepository.getCurrencies()

        verify(apiService, times(1)).getCurrenciesAsync()
        verifyNoMoreInteractions(apiService)
    }

}
