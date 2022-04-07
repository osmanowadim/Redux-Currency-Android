package osmanov.example.mvicurrencyandroid.data.cache.db

import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import osmanov.example.mvicurrencyandroid.data.cache.db.dao.CurrencyDao
import osmanov.example.mvicurrencyandroid.data.cache.db.entity.CurrencyEntity

class CurrencyDaoTest : TestRobolectric() {

    private lateinit var currencyDao: CurrencyDao

    private val currencies = listOf(
        CurrencyEntity(
            id = 1,
            name = "USD",
            code = "980",
            rate = 29.2,
            exchangeDate = "06.04.2022"
        ),
        CurrencyEntity(
            id = 2,
            name = "EUR",
            code = "972",
            rate = 32.1,
            exchangeDate = "06.04.2022"
        ),
        CurrencyEntity(
            id = 3,
            name = "LNK",
            code = "114",
            rate = 0.44,
            exchangeDate = "06.04.2022"
        )
    )

    @Before
    fun setUp() = runBlocking {
        super.createDb()
        currencyDao = database.getCurrencyDao()
    }

    @After
    fun tearDown() {
        super.closeDb()
    }

    @Test
    fun insertCurrenciesMustReturnValues() = runBlocking {
        currencyDao.insertCurrencies(currencies)
        val currenciesFromDb = currencyDao.getAllCurrencies()

        assertEquals(currencies.size, currenciesFromDb.size)
        assertEquals(currencies.first(), currenciesFromDb.first())
    }

    @Test
    fun insertEmptyCurrenciesMustReturnEmptyValues() = runBlocking {
        currencyDao.insertCurrencies(listOf())
        val currenciesFromDb = currencyDao.getAllCurrencies()

        assertEquals(0, currenciesFromDb.size)
    }

    @Test
    fun insertCurrenciesAndClearMustReturnEmptyValues() = runBlocking {
        currencyDao.insertCurrencies(currencies)
        val currenciesFromDb = currencyDao.getAllCurrencies()

        assertEquals(currencies.size, currenciesFromDb.size)
        assertEquals(currencies.first(), currenciesFromDb.first())

        currencyDao.clearAllCurrencies()
        val currenciesFromDb2 = currencyDao.getAllCurrencies()

        assertEquals(0, currenciesFromDb2.size)
    }

    @Test
    fun getCurrenciesFromEmptyDbMustReturnEmptyList() = runBlocking {
        val currenciesFromDb = currencyDao.getAllCurrencies()

        assertEquals(0, currenciesFromDb.size)
    }

}
