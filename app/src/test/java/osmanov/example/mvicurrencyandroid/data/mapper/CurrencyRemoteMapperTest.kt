package osmanov.example.mvicurrencyandroid.data.mapper

import org.junit.Assert
import org.junit.Test
import osmanov.example.mvicurrencyandroid.data.cache.db.entity.CurrencyEntity
import osmanov.example.mvicurrencyandroid.data.remote.model.CurrencyResponse
import osmanov.example.mvicurrencyandroid.model.CurrencyModel

class CurrencyRemoteMapperTest {

    private val mapper: CurrencyRemoteMapper = CurrencyRemoteMapper()

    private val fakeModel = CurrencyModel(
        id = 2,
        name = "USD",
        code = "23",
        rate = 29.2,
        exchangeDate = "06.04.2022"
    )
    private val fakeResponse = CurrencyResponse(
        id = 2,
        name = "USD",
        code = "23",
        rate = 29.2,
        exchangeDate = "06.04.2022"
    )

    @Test
    fun mapFromModelMustReturnModel() {
        Assert.assertEquals(fakeModel, mapper.mapToModel(fakeResponse))
    }

    @Test
    fun mapToCachedEntityMustReturnEntity() {
        Assert.assertEquals(fakeResponse, mapper.mapFromModel(fakeModel))
    }

}
