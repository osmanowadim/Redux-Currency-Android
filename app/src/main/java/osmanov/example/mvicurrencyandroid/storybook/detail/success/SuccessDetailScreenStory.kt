package osmanov.example.mvicurrencyandroid.storybook.detail.success

import androidx.navigation.NavController
import org.koin.core.module.Module
import osmanov.example.mvicurrencyandroid.model.CurrencyModel
import osmanov.example.mvicurrencyandroid.storybook.activity.StorybookFragmentDirections
import osmanov.example.mvicurrencyandroid.storybook.core.Story

const val SuccessDetailScreenStoryTitle = "Success Detail Screen Story"

/**
 * Success story for DetailFragment.
 */
class SuccessDetailScreenStory : Story {

    override val title: String = SuccessDetailScreenStoryTitle

    override fun present(
        navController: NavController,
        fakeModules: List<Module>,
        originModules: List<Module>
    ) {
        navController.navigate(
            StorybookFragmentDirections.storybookDetail(
                CurrencyModel(
                    id = 0,
                    name = "Fake usd",
                    code = "USD",
                    rate = 123.99,
                    exchangeDate = "01.07.2022"
                )
            )
        )
    }

}
