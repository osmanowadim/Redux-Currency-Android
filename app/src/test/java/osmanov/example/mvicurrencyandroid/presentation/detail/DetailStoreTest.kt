package osmanov.example.mvicurrencyandroid.presentation.detail

import org.junit.Assert.*
import org.junit.Test
import osmanov.example.mvicurrencyandroid.common.mvi.Store
import osmanov.example.mvicurrencyandroid.presentation.detail.mvi.*

class DetailStoreTest {

    private val store: Store<DetailState, DetailAction, DetailNews> = DetailStore()

    @Test
    fun getDetailReducerMustReturnValue() {
        val reducer = store.reducer

        assertNotNull(reducer)
        assertEquals(DetailReducer::class.java, reducer::class.java)
    }

    @Test
    fun getMiddlewaresMustReturnNotEmptyValue() {
        val middlewares = store.middlewares

        assertTrue(middlewares.isNotEmpty())
    }

}
