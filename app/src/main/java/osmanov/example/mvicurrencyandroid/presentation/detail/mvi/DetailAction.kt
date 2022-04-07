package osmanov.example.mvicurrencyandroid.presentation.detail.mvi

import osmanov.example.mvicurrencyandroid.common.mvi.Action

sealed class DetailAction : Action {

    object GetCurrencyExchange : DetailAction()

}
