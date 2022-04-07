package osmanov.example.mvicurrencyandroid.presentation.main.mvi

import androidx.navigation.NavDirections
import osmanov.example.mvicurrencyandroid.common.mvi.State
import osmanov.example.mvicurrencyandroid.data.remote.model.CurrencyResponse
import osmanov.example.mvicurrencyandroid.model.CurrencyModel

sealed class MainState : State {

    data class Default(
        val navDirections: NavDirections? = null
    ) : MainState()

    data class ShowList(
        val items: List<CurrencyModel>
    ) : MainState()

    object Loading : MainState()

    object Error : MainState()

}
