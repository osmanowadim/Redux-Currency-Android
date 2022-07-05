package osmanov.example.mvicurrencyandroid.core

import android.app.KeyguardManager
import android.content.Context
import android.view.WindowManager
import androidx.test.annotation.UiThreadTest
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Before
import org.junit.Rule
import osmanov.example.mvicurrencyandroid.storybook.activity.StorybookActivity

open class BaseStorybookTest {

    @get : Rule
    var activityRule = ActivityScenarioRule(StorybookActivity::class.java)

    @UiThreadTest
    @Before
    fun setUp() {
        activityRule.scenario.onActivity { activity ->
            activity.runOnUiThread {
                val kgm = activity.getSystemService(Context.KEYGUARD_SERVICE) as KeyguardManager
                val lock = kgm.newKeyguardLock(Context.KEYGUARD_SERVICE)
                lock.disableKeyguard()

                activity.window.addFlags(
                    WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED or WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD
                            or WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
                            or WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON
                            or WindowManager.LayoutParams.FLAG_ALLOW_LOCK_WHILE_SCREEN_ON
                )
            }
        }
    }

}
