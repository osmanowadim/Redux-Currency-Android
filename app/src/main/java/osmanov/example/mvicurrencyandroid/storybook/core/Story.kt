package osmanov.example.mvicurrencyandroid.storybook.core

import androidx.navigation.NavController
import org.koin.core.module.Module

interface Story {

    val title: String

    fun present(navController: NavController, fakeModules: List<Module>, originModules: List<Module>)

}
