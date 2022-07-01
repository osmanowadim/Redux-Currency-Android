package osmanov.example.mvicurrencyandroid.storybook.main.success

import androidx.navigation.NavController
import org.koin.core.module.Module
import osmanov.example.mvicurrencyandroid.R
import osmanov.example.mvicurrencyandroid.storybook.core.Story

class SuccessMainScreenStory : Story {

    override val title: String = "Success Main Screen Story"

    override fun present(
        navController: NavController,
        fakeModules: List<Module>,
        originModules: List<Module>
    ) {
        navController.navigate(R.id.storybookMain)
    }

}
