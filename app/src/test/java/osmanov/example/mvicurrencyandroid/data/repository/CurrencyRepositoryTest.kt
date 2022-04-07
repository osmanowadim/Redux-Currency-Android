package osmanov.example.mvicurrencyandroid.data.repository

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.dsl.module
import org.koin.test.AutoCloseKoinTest
import org.koin.test.inject
import osmanov.example.mvicurrencyandroid.data.cache.currency.CurrencyCacheContract
import osmanov.example.mvicurrencyandroid.data.remote.ApiRepositoryContract
import osmanov.example.mvicurrencyandroid.di.appModule
import osmanov.example.mvicurrencyandroid.model.CurrencyModel

class CurrencyRepositoryTest : AutoCloseKoinTest() {

    private val apiRepository: ApiRepositoryContract = mock()
    private val currencyCache: CurrencyCacheContract = mock()
    private val currencyRepository: CurrencyRepositoryContract by inject()


    companion object {
        val currencies = listOf(
            CurrencyModel(
                id = 1,
                name = "USD",
                code = "980",
                rate = 29.2,
                exchangeDate = "06.04.2022"
            ),
            CurrencyModel(
                id = 2,
                name = "EUR",
                code = "972",
                rate = 32.1,
                exchangeDate = "06.04.2022"
            )
        )
    }

    @Before
    fun setUp() {
        startKoin {
            modules(listOf(appModule, module {
                single<CurrencyRepositoryContract> {
                    CurrencyRepository(
                        apiRepository,
                        currencyCache
                    )
                }
            }))
        }
    }

    @Test
    fun getAvailableCurrenciesMustReturnNull() = runBlocking {
        whenever(currencyCache.getCurrencies()).thenReturn(emptyList())
        whenever(apiRepository.getCurrencies()).thenReturn(null)

        val availableCurrencies = currencyRepository.getAvailableCurrencies()

        assertEquals(null, availableCurrencies)
    }

    @Test
    fun getAvailableCurrenciesMustReturnCurrenciesFromDb() = runBlocking {
        whenever(currencyCache.getCurrencies()).thenReturn(currencies)
        whenever(apiRepository.getCurrencies()).thenReturn(null)

        val availableCurrencies = currencyRepository.getAvailableCurrencies()

        assertEquals(currencies, availableCurrencies)
    }

    @Test
    fun getAvailableCurrenciesMustReturnCurrenciesFromRemote() = runBlocking {
        whenever(currencyCache.getCurrencies()).thenReturn(null)
        whenever(apiRepository.getCurrencies()).thenReturn(currencies)

        val availableCurrencies = currencyRepository.getAvailableCurrencies()

        assertEquals(currencies, availableCurrencies)
    }

    @Test
    fun getAvailableCurrenciesMustReturnCurrenciesFromInMemoryCache() = runBlocking {
        whenever(currencyCache.getCurrencies()).thenReturn(null)
        whenever(apiRepository.getCurrencies()).thenReturn(currencies)

        val availableCurrencies = currencyRepository.getAvailableCurrencies()

        assertEquals(currencies, availableCurrencies)

        whenever(currencyCache.getCurrencies()).thenReturn(null)
        whenever(apiRepository.getCurrencies()).thenReturn(null)

        val availableCurrenciesFromInMemory = currencyRepository.getAvailableCurrencies()

        assertEquals(currencies, availableCurrenciesFromInMemory)
    }

}
