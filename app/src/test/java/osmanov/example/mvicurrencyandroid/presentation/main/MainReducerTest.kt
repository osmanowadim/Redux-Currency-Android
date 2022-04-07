package osmanov.example.mvicurrencyandroid.presentation.main

import android.widget.Toast
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import osmanov.example.mvicurrencyandroid.data.repository.CurrencyRepositoryTest
import osmanov.example.mvicurrencyandroid.presentation.main.mvi.MainAction
import osmanov.example.mvicurrencyandroid.presentation.main.mvi.MainNews
import osmanov.example.mvicurrencyandroid.presentation.main.mvi.MainReducer
import osmanov.example.mvicurrencyandroid.presentation.main.mvi.MainState
import osmanov.example.mvicurrencyandroid.presentation.main.ui.MainFragmentDirections

class MainReducerTest {

    private val mainReducer = MainReducer()

    @Test
    fun setNullGetCurrenciesDoneMustReturnError() = runBlocking {
        val reducerPair = mainReducer(MainState.Default(), MainAction.GetCurrenciesDone())

        assertEquals(
            MainState.Error to MainNews.Message(Toast.LENGTH_SHORT, "Empty currencies"),
            reducerPair
        )
    }

    @Test
    fun setNullGetCurrenciesDoneWithLoadingStateMustReturnError() = runBlocking {
        val reducerPair = mainReducer(MainState.Loading, MainAction.GetCurrenciesDone())

        assertEquals(
            MainState.Error to MainNews.Message(Toast.LENGTH_SHORT, "Empty currencies"),
            reducerPair
        )
    }

    @Test
    fun setEmptyGetCurrenciesDoneMustReturnError() = runBlocking {
        val reducerPair = mainReducer(MainState.Default(), MainAction.GetCurrenciesDone(listOf()))

        assertEquals(
            MainState.Error to MainNews.Message(Toast.LENGTH_SHORT, "Empty currencies"),
            reducerPair
        )
    }

    @Test
    fun setNotEmptyGetCurrenciesDoneMustReturnShowList() = runBlocking {
        val reducerPair = mainReducer(
            MainState.Default(), MainAction.GetCurrenciesDone(
                CurrencyRepositoryTest.currencies
            )
        )

        assertEquals(
            MainState.ShowList(CurrencyRepositoryTest.currencies) to null,
            reducerPair
        )
    }

    @Test
    fun setGetCurrenciesMustReturnLoading() = runBlocking {
        val reducerPair = mainReducer(
            MainState.Default(), MainAction.GetCurrencies
        )

        assertEquals(
            MainState.Loading to null,
            reducerPair
        )
    }

    @Test
    fun setGetCurrenciesWithErrorStateMustReturnLoading() = runBlocking {
        val reducerPair = mainReducer(
            MainState.Error, MainAction.GetCurrencies
        )

        assertEquals(
            MainState.Loading to null,
            reducerPair
        )
    }

    @Test
    fun setCurrencyItemClickedMustReturnDefaultWithNavDirections() = runBlocking {
        val reducerPair = mainReducer(
            MainState.Default(),
            MainAction.CurrencyItemClicked(CurrencyRepositoryTest.currencies.first())
        )

        assertEquals(
            MainState.Default(MainFragmentDirections.mainDetail(CurrencyRepositoryTest.currencies.first())) to null,
            reducerPair
        )
    }

    @Test
    fun setCurrencyItemClickedWithLoadingStateMustReturnDefaultWithNavDirections() = runBlocking {
        val reducerPair = mainReducer(
            MainState.Loading,
            MainAction.CurrencyItemClicked(CurrencyRepositoryTest.currencies.first())
        )

        assertEquals(
            MainState.Default(MainFragmentDirections.mainDetail(CurrencyRepositoryTest.currencies.first())) to null,
            reducerPair
        )
    }

}
