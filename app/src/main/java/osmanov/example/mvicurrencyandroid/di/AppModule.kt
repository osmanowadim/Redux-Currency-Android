package osmanov.example.mvicurrencyandroid.di

import android.content.Context
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

/**
 * Module for applications dependency. Like [Context], SharedPreferences...
 */
val appModule = module(override = true) {
    single<Context> { androidApplication() }
    //Here we can init main preferences
}
