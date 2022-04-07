package osmanov.example.mvicurrencyandroid.presentation.main.mvi

import android.widget.Toast
import osmanov.example.mvicurrencyandroid.common.mvi.Reducer
import osmanov.example.mvicurrencyandroid.presentation.main.ui.MainFragment
import osmanov.example.mvicurrencyandroid.presentation.main.ui.MainFragmentDirections

class MainReducer : Reducer<MainState, MainAction, MainNews> {

    override fun reduce(state: MainState, action: MainAction): Pair<MainState?, MainNews?> {
        var reducedState: MainState? = null
        var reducedNews: MainNews? = null
        when (action) {
            is MainAction.GetCurrenciesDone -> {
                if (action.currencies.isNullOrEmpty()) {
                    reducedNews = MainNews.Message(Toast.LENGTH_SHORT, "Empty currencies")
                    reducedState = MainState.Error
                } else {
                    reducedState = MainState.ShowList(action.currencies)
                }
            }
            is MainAction.GetCurrencies -> {
                reducedState = MainState.Loading
            }
            is MainAction.CurrencyItemClicked ->{
                reducedState = MainState.Default(MainFragmentDirections.mainDetail(action.currency))
            }
        }
        return reducedState to reducedNews
    }

}
