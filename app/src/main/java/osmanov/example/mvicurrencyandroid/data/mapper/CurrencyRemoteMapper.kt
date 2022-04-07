package osmanov.example.mvicurrencyandroid.data.mapper

import osmanov.example.mvicurrencyandroid.data.remote.model.CurrencyResponse
import osmanov.example.mvicurrencyandroid.model.CurrencyModel

/**
 * Mapper for Currency in Remote.
 * Where [CurrencyResponse] incoming class, [CurrencyModel] - outgoing class
 */
class CurrencyRemoteMapper : CachedEntityMapper<CurrencyResponse, CurrencyModel> {

    override fun mapToModel(type: CurrencyResponse): CurrencyModel {
        return CurrencyModel(
            id = type.id,
            name = type.name,
            code = type.code,
            rate = type.rate,
            exchangeDate = type.exchangeDate
        )
    }

    override fun mapFromModel(type: CurrencyModel): CurrencyResponse {
        return CurrencyResponse(
            id = type.id,
            name = type.name,
            code = type.code,
            rate = type.rate,
            exchangeDate = type.exchangeDate
        )
    }

}
