package osmanov.example.mvicurrencyandroid.storybook.main.error

import osmanov.example.mvicurrencyandroid.common.mvi.Middleware
import osmanov.example.mvicurrencyandroid.presentation.main.mvi.MainAction

class FakeErrorGetCurrenciesMiddleware : Middleware<MainAction>() {

    override suspend fun effect(action: MainAction): MainAction? {
        var effect: MainAction? = null
        with(action) {
            if (this is MainAction.GetCurrencies) {
                effect = MainAction.GetCurrenciesDone()
            }
        }
        return effect
    }

}
