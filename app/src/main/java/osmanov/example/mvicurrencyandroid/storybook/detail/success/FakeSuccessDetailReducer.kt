package osmanov.example.mvicurrencyandroid.storybook.detail.success

import osmanov.example.mvicurrencyandroid.common.mvi.Reducer
import osmanov.example.mvicurrencyandroid.presentation.detail.mvi.DetailAction
import osmanov.example.mvicurrencyandroid.presentation.detail.mvi.DetailNews
import osmanov.example.mvicurrencyandroid.presentation.detail.mvi.DetailState

/**
 * Fake [Reducer] for Success Story. Always return Success if currency is not null.
 */
class FakeSuccessDetailReducer : Reducer<DetailState, DetailAction, DetailNews> {

    override fun reduce(state: DetailState, action: DetailAction): Pair<DetailState?, DetailNews?> {
        var reducedState: DetailState? = null
        if (action is DetailAction.GetCurrencyExchangeDone) {
            reducedState = action.currency?.let {
                DetailState.Success(action.currency)
            } ?: DetailState.Error
        }
        return reducedState to null
    }

}
