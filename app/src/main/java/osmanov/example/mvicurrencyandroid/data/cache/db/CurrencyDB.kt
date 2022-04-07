package osmanov.example.mvicurrencyandroid.data.cache.db

import androidx.room.Database
import androidx.room.RoomDatabase
import osmanov.example.mvicurrencyandroid.data.cache.db.dao.CurrencyDao
import osmanov.example.mvicurrencyandroid.data.cache.db.entity.CurrencyEntity

/**
 * Class for working with DB. Allow getting access to DAO from DB.
 * Contains tables from DB in param entities. Also need to update version in case of changing DB data.
 */
@Database(entities = [CurrencyEntity::class], version = 1)
abstract class CurrencyDB : RoomDatabase() {

    abstract fun getCurrencyDao(): CurrencyDao

}
