package osmanov.example.mvicurrencyandroid.common.mvi

/**
 * Base interface which represent View for MVI pattern.
 * Where [S] - is State, [N] - News
 */
interface MviView<S : State, N : News> {

    fun renderState(state: S)

    fun renderNews(new: N)

}
