package osmanov.example.mvicurrencyandroid.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

/**
 * Base class for all Fragments.
 *
 * @param layoutId - [Int] layout res id. Need for set layout to current fragment
 */
abstract class BaseFragment(@LayoutRes private val layoutId: Int) : Fragment() {

    /**
     * Set layout [layoutId] to Fragment.
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layoutId, container, false)
    }

}
