package osmanov.example.mvicurrencyandroid.storybook.detail.error

import android.widget.Toast
import osmanov.example.mvicurrencyandroid.common.mvi.Reducer
import osmanov.example.mvicurrencyandroid.presentation.detail.mvi.DetailAction
import osmanov.example.mvicurrencyandroid.presentation.detail.mvi.DetailNews
import osmanov.example.mvicurrencyandroid.presentation.detail.mvi.DetailState

/**
 * Fake [Reducer] for Error Story. Always return Error.
 */
class FakeErrorDetailReducer : Reducer<DetailState, DetailAction, DetailNews> {

    override fun reduce(state: DetailState, action: DetailAction): Pair<DetailState?, DetailNews?> {
        var reducedState: DetailState? = null
        var reducedNews: DetailNews? = null
        if (action is DetailAction.GetCurrencyExchangeDone) {
            reducedNews = DetailNews.Message(Toast.LENGTH_SHORT, "Something going wrong")
            reducedState = DetailState.Error
        }
        return reducedState to reducedNews
    }

}
