package osmanov.example.mvicurrencyandroid.presentation.detail

import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import osmanov.example.mvicurrencyandroid.presentation.detail.mvi.DetailAction
import osmanov.example.mvicurrencyandroid.presentation.detail.mvi.DetailReducer
import osmanov.example.mvicurrencyandroid.presentation.detail.mvi.DetailState

class DetailReducerTest {

    private val detailReducer = DetailReducer()

    @Test
    fun setGetCurrencyExchangeMustReturnDefault() = runBlocking {
        val reducerPair = detailReducer(DetailState.Default, DetailAction.GetCurrencyExchange)

        Assert.assertEquals(
            DetailState.Default to null,
            reducerPair
        )
    }

}
