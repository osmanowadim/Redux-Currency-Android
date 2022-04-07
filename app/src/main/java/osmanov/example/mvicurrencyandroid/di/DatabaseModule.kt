package osmanov.example.mvicurrencyandroid.di

import androidx.room.Room
import org.koin.dsl.module
import osmanov.example.mvicurrencyandroid.data.cache.db.CurrencyDB

/**
 * Module for DB dependency. Like [CurrencyDB], DatabaseBuilder...
 */
val databaseModule = module {
    single { (get() as CurrencyDB).getCurrencyDao() }
    single {
        Room.databaseBuilder(get(), CurrencyDB::class.java, "currency.db").build()
    }
}
