package osmanov.example.mvicurrencyandroid.presentation.detail.mvi

import osmanov.example.mvicurrencyandroid.common.mvi.Reducer

class DetailReducer : Reducer<DetailState, DetailAction, DetailNews> {

    override fun reduce(state: DetailState, action: DetailAction): Pair<DetailState?, DetailNews?> {
        var reducedState: DetailState? = null
        var reducedNews: DetailNews? = null
        when (action) {
            is DetailAction.GetCurrencyExchange -> {
                reducedState = DetailState.Default
            }
        }
        return reducedState to reducedNews
    }

}
