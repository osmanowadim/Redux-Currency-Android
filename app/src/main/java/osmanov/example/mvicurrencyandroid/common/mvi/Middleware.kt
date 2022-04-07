package osmanov.example.mvicurrencyandroid.common.mvi

/**
 * Base class which represent Middleware for MVI pattern.
 * Where [A] - is Action
 */
abstract class Middleware<A>() {

    abstract suspend fun effect(action: A): A?

    suspend operator fun invoke(action: A) = effect(action)

}
