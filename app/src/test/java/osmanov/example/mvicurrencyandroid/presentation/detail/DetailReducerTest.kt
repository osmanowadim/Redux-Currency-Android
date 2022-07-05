package osmanov.example.mvicurrencyandroid.presentation.detail

import android.widget.Toast
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import osmanov.example.mvicurrencyandroid.presentation.detail.mvi.DetailAction
import osmanov.example.mvicurrencyandroid.presentation.detail.mvi.DetailNews
import osmanov.example.mvicurrencyandroid.presentation.detail.mvi.DetailReducer
import osmanov.example.mvicurrencyandroid.presentation.detail.mvi.DetailState

class DetailReducerTest {

    private val detailReducer = DetailReducer()

    @Test
    fun setGetCurrencyExchangeMustReturnDefault() = runBlocking {
        val reducerPair = detailReducer(DetailState.Default, DetailAction.GetCurrencyExchangeDone(null))

        Assert.assertEquals(
            DetailState.Error to DetailNews.Message(Toast.LENGTH_SHORT, "Something going wrong"),
            reducerPair
        )
    }

}
