package osmanov.example.mvicurrencyandroid.data.mapper

import osmanov.example.mvicurrencyandroid.data.cache.db.entity.CurrencyEntity
import osmanov.example.mvicurrencyandroid.model.CurrencyModel

/**
 * Mapper for Currency in DB
 * Where [CurrencyEntity] incoming class, [CurrencyModel] - outgoing class
 */
class CurrencyEntityMapper : CachedEntityMapper<CurrencyEntity, CurrencyModel> {

    override fun mapToModel(type: CurrencyEntity): CurrencyModel {
        return CurrencyModel(
            id = type.id,
            name = type.name,
            code = type.code,
            rate = type.rate,
            exchangeDate = type.exchangeDate
        )
    }

    override fun mapFromModel(type: CurrencyModel): CurrencyEntity {
        return CurrencyEntity(
            id = type.id,
            name = type.name,
            code = type.code,
            rate = type.rate,
            exchangeDate = type.exchangeDate
        )
    }

}
