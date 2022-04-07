package osmanov.example.mvicurrencyandroid.common.extensions

import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect

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
