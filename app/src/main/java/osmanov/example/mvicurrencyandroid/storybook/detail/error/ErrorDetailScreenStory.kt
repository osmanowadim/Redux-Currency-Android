package osmanov.example.mvicurrencyandroid.storybook.detail.error

import androidx.navigation.NavController
import org.koin.core.module.Module
import osmanov.example.mvicurrencyandroid.storybook.activity.StorybookFragmentDirections
import osmanov.example.mvicurrencyandroid.storybook.core.Story

class ErrorDetailScreenStory : Story {

    override val title: String = "Error Detail Screen Story"

    override fun present(
        navController: NavController,
        fakeModules: List<Module>,
        originModules: List<Module>
    ) {
        navController.navigate(
            StorybookFragmentDirections.storybookDetail(null)
        )
    }

}
