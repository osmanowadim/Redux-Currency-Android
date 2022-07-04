package osmanov.example.mvicurrencyandroid.storybook.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import osmanov.example.mvicurrencyandroid.R

/**
 * Entry point for Storybook flow. Set Activity UI, navigation and new start destination.
 */
class StorybookActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_storybook)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment

        val navController = navHostFragment.navController
        val navGraph = navController.navInflater.inflate(R.navigation.main_navigation).also {
         it.setStartDestination(R.id.fragment_storybook)
        }
        navController.graph = navGraph
    }

}
