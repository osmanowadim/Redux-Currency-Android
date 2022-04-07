package osmanov.example.mvicurrencyandroid.di

import android.content.Context
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import osmanov.example.mvicurrencyandroid.BuildConfig

object DiGraph {

    fun start(context: Context) {
        startKoin {
            androidContext(context)
            if (BuildConfig.DEBUG) androidLogger(level = Level.ERROR)
            modules(diModules)
        }
    }

    private val diModules = listOf(
        appModule,
        networkModule,
        databaseModule,
        repositoryModule,
        *featureModules
    )

}
