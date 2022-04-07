package osmanov.example.mvicurrencyandroid.presentation.main

import com.nhaarman.mockito_kotlin.given
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import osmanov.example.mvicurrencyandroid.common.mvi.Middleware
import osmanov.example.mvicurrencyandroid.data.repository.CurrencyRepositoryContract
import osmanov.example.mvicurrencyandroid.data.repository.CurrencyRepositoryTest
import osmanov.example.mvicurrencyandroid.presentation.main.middlewares.GetCurrenciesMiddleware
import osmanov.example.mvicurrencyandroid.presentation.main.mvi.MainAction

class GetCurrenciesMiddlewareTest {

    private val repository: CurrencyRepositoryContract = mock()
    private val getCurrenciesMiddleware: Middleware<MainAction> =
        GetCurrenciesMiddleware(repository)

    @Test
    fun getNullInRepositoryMustReturnEmptyDone() = runBlocking {
        whenever(repository.getAvailableCurrencies()).thenReturn(null)

        val action = getCurrenciesMiddleware.effect(MainAction.GetCurrencies)

        assertEquals(MainAction.GetCurrenciesDone(), action)
    }

    @Test
    fun getEmptyInRepositoryMustReturnEmptyDone() = runBlocking {
        whenever(repository.getAvailableCurrencies()).thenReturn(listOf())

        val action = getCurrenciesMiddleware.effect(MainAction.GetCurrencies)

        assertEquals(MainAction.GetCurrenciesDone(), action)
    }

    @Test
    fun getExceptionInRepositoryMustReturnEmptyDone() = runBlocking {
        given(repository.getAvailableCurrencies()).willAnswer { throw Exception("test exception") }

        val action = getCurrenciesMiddleware.effect(MainAction.GetCurrencies)

        assertEquals(MainAction.GetCurrenciesDone(), action)
    }

    @Test
    fun getListInRepositoryMustReturnDoneWithList() = runBlocking {
        whenever(repository.getAvailableCurrencies()).thenReturn(CurrencyRepositoryTest.currencies)

        val action = getCurrenciesMiddleware.effect(MainAction.GetCurrencies)

        assertEquals(MainAction.GetCurrenciesDone(CurrencyRepositoryTest.currencies), action)
    }

    @Test
    fun postWrongActionMustReturnNull() = runBlocking {
        whenever(repository.getAvailableCurrencies()).thenReturn(null)

        val action = getCurrenciesMiddleware.effect(MainAction.GetCurrenciesDone())

        assertEquals(null, action)
    }

}
