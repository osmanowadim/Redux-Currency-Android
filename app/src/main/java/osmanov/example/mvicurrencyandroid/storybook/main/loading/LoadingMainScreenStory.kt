package osmanov.example.mvicurrencyandroid.storybook.main.loading

import androidx.navigation.NavController
import org.koin.core.module.Module
import osmanov.example.mvicurrencyandroid.R
import osmanov.example.mvicurrencyandroid.common.extensions.swapModules
import osmanov.example.mvicurrencyandroid.storybook.core.Story

class LoadingMainScreenStory : Story {

    override val title: String = "Loading Main Screen Story"

    override fun present(navController: NavController, fakeModules: List<Module>, originModules: List<Module>) {
        swapModules(
            loadModules = fakeModules,
            unloadModules = originModules
        )
        navController.navigate(R.id.storybookMain)
    }

}
