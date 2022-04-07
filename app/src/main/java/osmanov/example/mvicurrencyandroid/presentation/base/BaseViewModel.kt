package osmanov.example.mvicurrencyandroid.presentation.base

import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import osmanov.example.mvicurrencyandroid.common.extensions.launchWhenStarted
import osmanov.example.mvicurrencyandroid.common.mvi.*

/**
 * Base class which represent ViewModel according to MVI pattern.
 * Where [S] - is State, [A] - Action, [N] - News.
 */
abstract class BaseViewModel<S : State, A : Action, N : News> : ViewModel() {

    abstract val stateFlow: MutableStateFlow<S>
    abstract val newsFlow: MutableSharedFlow<N>
    abstract val actionFlow: MutableSharedFlow<A?>
    abstract val store: Store<S, A, N>

    /**
     * Emit new [A] action to [actionFlow].
     *
     * @param action - [A].
     */
    suspend fun obtainAction(action: A) {
        actionFlow.emit(action)
    }

    /**
     * Emit new [S] state to [stateFlow] in Scope [viewModelScope].
     *
     * @param state - [S].
     */
    fun obtainState(state: S) {
        viewModelScope.launch {
            stateFlow.emit(state)
        }
    }

    /**
     * Bind flows to [LifecycleCoroutineScope].
     *
     * @param lifecycleScope - [LifecycleCoroutineScope] CoroutineScope tied to a Lifecycle.
     * @param mviView - [MviView] View in MVI pattern.
     */
    fun bind(lifecycleScope: LifecycleCoroutineScope, mviView: MviView<S, N>) {
        stateFlow
            .onEach(mviView::renderState)
            .launchWhenStarted(lifecycleScope)

        newsFlow
            .onEach(mviView::renderNews)
            .launchWhenStarted(lifecycleScope)

        lifecycleScope.launch {
            actionFlow.collect {
                it?.let {
                    CoroutineScope(Dispatchers.Default).launch {
                        store.middlewares.forEach { middleware ->
                            middleware(it)?.let { action ->
                                actionFlow.emit(action)
                            }
                        }
                    }
                    val reduced = store.reducer(stateFlow.value, it)
                    reduced.first?.let { state ->
                        stateFlow.value = state
                    }
                    reduced.second?.let { news ->
                        newsFlow.emit(news)
                    }
                }
            }
        }
    }
}
