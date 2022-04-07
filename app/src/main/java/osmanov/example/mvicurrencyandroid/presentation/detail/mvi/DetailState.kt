package osmanov.example.mvicurrencyandroid.presentation.detail.mvi

import osmanov.example.mvicurrencyandroid.common.mvi.State

sealed class DetailState : State {

    object Default : DetailState()

}
