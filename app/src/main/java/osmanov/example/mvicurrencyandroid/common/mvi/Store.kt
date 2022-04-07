package osmanov.example.mvicurrencyandroid.common.mvi

/**
 * Base class which represent Store for MVI pattern.
 * Where [S] - is State, [A] - Action, [N] - News
 */
open class Store<S : State, A : Action, N : News> {

    lateinit var middlewares: List<Middleware<A>>

    lateinit var reducer: Reducer<S, A, N>

}
