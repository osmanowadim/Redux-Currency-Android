package osmanov.example.mvicurrencyandroid.presentation.main.ui

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import osmanov.example.mvicurrencyandroid.presentation.base.BaseViewModel
import osmanov.example.mvicurrencyandroid.presentation.main.mvi.MainAction
import osmanov.example.mvicurrencyandroid.presentation.main.mvi.MainNews
import osmanov.example.mvicurrencyandroid.presentation.main.mvi.MainState
import osmanov.example.mvicurrencyandroid.presentation.main.mvi.MainStore

class MainViewModel(
    mainStore: MainStore
) : BaseViewModel<MainState, MainAction, MainNews>() {

    override val stateFlow = MutableStateFlow<MainState>(MainState.Default())
    override val actionFlow = MutableSharedFlow<MainAction?>()
    override val newsFlow = MutableSharedFlow<MainNews>()

    override val store: MainStore = mainStore

}
