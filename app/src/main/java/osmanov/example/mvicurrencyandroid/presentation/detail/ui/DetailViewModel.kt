package osmanov.example.mvicurrencyandroid.presentation.detail.ui

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import osmanov.example.mvicurrencyandroid.presentation.base.BaseViewModel
import osmanov.example.mvicurrencyandroid.presentation.detail.mvi.DetailAction
import osmanov.example.mvicurrencyandroid.presentation.detail.mvi.DetailNews
import osmanov.example.mvicurrencyandroid.presentation.detail.mvi.DetailState
import osmanov.example.mvicurrencyandroid.presentation.detail.mvi.DetailStore

class DetailViewModel(
    mainStore: DetailStore
) : BaseViewModel<DetailState, DetailAction, DetailNews>() {

    override val stateFlow = MutableStateFlow<DetailState>(DetailState.Default)
    override val actionFlow = MutableSharedFlow<DetailAction?>()
    override val newsFlow = MutableSharedFlow<DetailNews>()

    override val store: DetailStore = mainStore

}
