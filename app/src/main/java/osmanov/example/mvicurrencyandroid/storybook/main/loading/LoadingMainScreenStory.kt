package osmanov.example.mvicurrencyandroid.storybook.main.loading

import androidx.navigation.NavController
import org.koin.core.module.Module
import osmanov.example.mvicurrencyandroid.R
import osmanov.example.mvicurrencyandroid.storybook.core.Story

const val LoadingMainScreenStoryTitle = "Loading Main Screen Story"

/**
 * Loading story for MainFragment.
 */
class LoadingMainScreenStory : Story {

    override val title: String = LoadingMainScreenStoryTitle

    override fun present(
        navController: NavController,
        fakeModules: List<Module>,
        originModules: List<Module>
    ) {
        navController.navigate(R.id.storybookMain)
    }

}
