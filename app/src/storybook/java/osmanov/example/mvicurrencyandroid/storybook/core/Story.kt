package osmanov.example.mvicurrencyandroid.storybook.core

import androidx.navigation.NavController

/**
 * Base interface which represent Story for Storybook flow.
 * Where [title] - name of the Story and present() - open story.
 */
interface Story {

    val title: String

    fun present(navController: NavController)

}
