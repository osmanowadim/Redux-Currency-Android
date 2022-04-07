package osmanov.example.mvicurrencyandroid.data.cache.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import osmanov.example.mvicurrencyandroid.data.cache.db.dao.CurrencyDao

/**
 * Table in DB. Represent Currency Entity
 */
@Entity(tableName = CurrencyDao.TABLE_NAME)
data class CurrencyEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val name: String,
    val code: String,
    val rate: Double,
    val exchangeDate: String
)
