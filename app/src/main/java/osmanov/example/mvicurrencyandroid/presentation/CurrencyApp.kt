package osmanov.example.mvicurrencyandroid.presentation

import android.app.Application
import osmanov.example.mvicurrencyandroid.di.DiGraph

/**
 * Application class. Used to initialize [DiGraph].
 */
class CurrencyApp : Application() {

    override fun onCreate() {
        super.onCreate()

        DiGraph.start(this)
    }

}
