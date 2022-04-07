package osmanov.example.mvicurrencyandroid.data.cache.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import osmanov.example.mvicurrencyandroid.data.cache.db.entity.CurrencyEntity

@Dao
interface CurrencyDao {

    /**
     * Insert [cachedCurrenciesEntity] to DB using REPLACE strategy -
     * OnConflict strategy constant to replace the old data and continue the transaction.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCurrencies(cachedCurrenciesEntity: List<CurrencyEntity>)

    /**
     * Clear all data from DB
     */
    @Query("DELETE FROM $TABLE_NAME")
    suspend fun clearAllCurrencies()

    /**
     * @return List[CurrencyEntity] from DB.
     * If DB is empty - return empty list
     */
    @Query("SELECT * FROM $TABLE_NAME")
    suspend fun getAllCurrencies(): List<CurrencyEntity>

    companion object {

        const val TABLE_NAME = "currency"

    }

}
