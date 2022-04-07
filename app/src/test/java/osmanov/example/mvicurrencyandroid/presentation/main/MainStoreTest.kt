package osmanov.example.mvicurrencyandroid.presentation.main

import com.nhaarman.mockito_kotlin.mock
import org.junit.Assert.*
import org.junit.Test
import osmanov.example.mvicurrencyandroid.common.mvi.Store
import osmanov.example.mvicurrencyandroid.data.repository.CurrencyRepositoryContract
import osmanov.example.mvicurrencyandroid.presentation.main.middlewares.GetCurrenciesMiddleware
import osmanov.example.mvicurrencyandroid.presentation.main.mvi.*

class MainStoreTest {

    private val repository: CurrencyRepositoryContract = mock()
    private val store: Store<MainState, MainAction, MainNews> = MainStore(repository)

    @Test
    fun getMainReducerMustReturnValue() {
        val reducer = store.reducer

        assertNotNull(reducer)
        assertEquals(MainReducer::class.java, reducer::class.java)
    }

    @Test
    fun getMiddlewaresMustReturnValue() {
        val middlewares = store.middlewares

        assertFalse(middlewares.isNullOrEmpty())
        assertEquals(GetCurrenciesMiddleware::class.java, middlewares.first()::class.java)
    }

}
