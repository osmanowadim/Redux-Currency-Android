package osmanov.example.mvicurrencyandroid.core

import android.os.SystemClock
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import org.hamcrest.CoreMatchers
import org.hamcrest.Matcher
import osmanov.example.mvicurrencyandroid.R

/**
 * Click on [R.id.ivArrow] for current item if possible.
 */
class StorybookRecyclerViewAction : ViewAction {

    override fun getConstraints(): Matcher<View> {
        return CoreMatchers.any(View::class.java)
    }

    override fun getDescription(): String {
        return "Performing action on RecyclerView child item"
    }

    override fun perform(uiController: UiController?, view: View?) {
        view?.findViewById<ImageView>(R.id.ivArrow)?.apply {

            //Generalized for OnClickListeners as well
            if (isEnabled && isClickable && !performClick()) {
                //Define click event
                val event: MotionEvent = MotionEvent.obtain(
                    SystemClock.uptimeMillis(),
                    SystemClock.uptimeMillis(),
                    MotionEvent.ACTION_UP,
                    view.x,
                    view.y,
                    0
                )

                if (!dispatchTouchEvent(event))
                    throw Exception("Not clicking!")
            }
        }
    }
}
