package osmanov.example.mvicurrencyandroid.storybook.detail.error

import android.widget.Toast
import osmanov.example.mvicurrencyandroid.common.mvi.Reducer
import osmanov.example.mvicurrencyandroid.presentation.detail.mvi.DetailAction
import osmanov.example.mvicurrencyandroid.presentation.detail.mvi.DetailNews
import osmanov.example.mvicurrencyandroid.presentation.detail.mvi.DetailState

class FakeErrorDetailReducer : Reducer<DetailState, DetailAction, DetailNews> {

    override fun reduce(state: DetailState, action: DetailAction): Pair<DetailState?, DetailNews?> {
        var reducedState: DetailState? = null
        var reducedNews: DetailNews? = null
        when (action) {
            is DetailAction.GetCurrencyExchangeDone -> {
                action.currency?.let {
                    reducedState = DetailState.Success(action.currency)
                } ?: let {
                    reducedNews = DetailNews.Message(Toast.LENGTH_SHORT, "Something going wrong")
                    reducedState = DetailState.Error
                }
            }
        }
        return reducedState to reducedNews
    }

}
