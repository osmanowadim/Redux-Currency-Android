package osmanov.example.mvicurrencyandroid.storybook.main.loading

import osmanov.example.mvicurrencyandroid.common.mvi.Middleware
import osmanov.example.mvicurrencyandroid.presentation.main.mvi.MainAction

/**
 * Fake [Middleware] for Loading Story. Always return null.
 */
class FakeLoadingGetCurrenciesMiddleware : Middleware<MainAction>() {

    override suspend fun effect(action: MainAction): MainAction? {
        return null
    }

}
