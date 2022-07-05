package osmanov.example.mvicurrencyandroid.common.extensions

import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules
import org.koin.core.module.Module

/**
 * Navigate to [where] using [NavController]
 *
 * @param where - [NavDirections] directions to open
 */
fun Fragment.navigate(where: NavDirections) = findNavController().navigate(where)

/**
 * Collect flow items after start [lifecycleScope]
 *
 * @param lifecycleScope - [LifecycleCoroutineScope] CoroutineScope tied to a Lifecycle
 */
fun <T> Flow<T>.launchWhenStarted(lifecycleScope: LifecycleCoroutineScope) {
    lifecycleScope.launchWhenStarted {
        this@launchWhenStarted.collect()
    }
}

/**
 * Change Koin modules [loadModules], [unloadModules] dynamically.
 *
 * @param loadModules - list of [Module] which will be loaded in global Koin context.
 * @param unloadModules - list of [Module] which will be unloaded in global Koin context.
 */
fun swapModules(loadModules: List<Module>, unloadModules: List<Module>) {
    unloadKoinModules(unloadModules)
    loadKoinModules(loadModules)
}
