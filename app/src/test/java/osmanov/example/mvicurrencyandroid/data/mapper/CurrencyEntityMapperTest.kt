package osmanov.example.mvicurrencyandroid.data.mapper

import org.junit.Assert.assertEquals
import org.junit.Test
import osmanov.example.mvicurrencyandroid.data.cache.db.entity.CurrencyEntity
import osmanov.example.mvicurrencyandroid.model.CurrencyModel

class CurrencyEntityMapperTest {

    private val mapper: CurrencyEntityMapper = CurrencyEntityMapper()

    private val fakeModel = CurrencyModel(
        id = 2,
        name = "USD",
        code = "23",
        rate = 29.2,
        exchangeDate = "06.04.2022"
    )
    private val fakeEntity = CurrencyEntity(
        id = 2,
        name = "USD",
        code = "23",
        rate = 29.2,
        exchangeDate = "06.04.2022"
    )

    @Test
    fun mapFromCachedEntityMustReturnModel() {
        assertEquals(fakeModel, mapper.mapToModel(fakeEntity))
    }

    @Test
    fun mapToCachedEntityMustReturnEntity() {
        assertEquals(fakeEntity, mapper.mapFromModel(fakeModel))
    }

}
