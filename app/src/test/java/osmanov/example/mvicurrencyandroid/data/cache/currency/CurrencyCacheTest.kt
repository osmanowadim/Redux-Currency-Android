package osmanov.example.mvicurrencyandroid.data.cache.currency

import com.nhaarman.mockito_kotlin.*
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.dsl.module
import org.koin.test.AutoCloseKoinTest
import org.koin.test.inject
import osmanov.example.mvicurrencyandroid.data.cache.db.dao.CurrencyDao
import osmanov.example.mvicurrencyandroid.data.cache.db.entity.CurrencyEntity
import osmanov.example.mvicurrencyandroid.data.mapper.CurrencyEntityMapper
import osmanov.example.mvicurrencyandroid.di.appModule
import osmanov.example.mvicurrencyandroid.model.CurrencyModel

class CurrencyCacheTest : AutoCloseKoinTest() {

    private val currencyDao: CurrencyDao = mock()
    private val currencyEntityMapper: CurrencyEntityMapper = CurrencyEntityMapper()
    private val currencyCache: CurrencyCacheContract by inject()

    @Before
    fun setUp() {
        startKoin {
            modules(listOf(appModule, module {
                single<CurrencyCacheContract> { CurrencyCache(currencyDao, currencyEntityMapper) }
            }))
        }
    }

    @Test
    fun getCurrenciesFromDbReturnValues() = runBlocking {
        whenever(currencyDao.getAllCurrencies()).thenReturn(
            listOf(
                CurrencyEntity(
                    id = 1,
                    name = "USD",
                    code = "980",
                    rate = 29.2,
                    exchangeDate = "06.04.2022"
                )
            )
        )

        assertEquals(1, currencyCache.getCurrencies().size)
        verify(currencyDao, times(1)).getAllCurrencies()
        verifyNoMoreInteractions(currencyDao)
    }

    @Test
    fun saveCurrenciesToDbMustCallDaoMethod() = runBlocking {
        whenever(currencyDao.insertCurrencies(any())).thenReturn(Unit)

        val currencies = listOf(
            CurrencyModel(
                id = 1,
                name = "USD",
                code = "980",
                rate = 29.2,
                exchangeDate = "06.04.2022"
            )
        )

        currencyCache.saveCurrencies(currencies)

        verify(currencyDao, times(1)).insertCurrencies(any())
        verifyNoMoreInteractions(currencyDao)
    }

}
