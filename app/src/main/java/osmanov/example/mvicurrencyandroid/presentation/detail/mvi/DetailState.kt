package osmanov.example.mvicurrencyandroid.presentation.detail.mvi

import osmanov.example.mvicurrencyandroid.common.mvi.State
import osmanov.example.mvicurrencyandroid.model.CurrencyModel

sealed class DetailState : State {

    object Default : DetailState()

    data class Success(val currency: CurrencyModel) : DetailState()

    object Error : DetailState()

}
