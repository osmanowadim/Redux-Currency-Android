package osmanov.example.mvicurrencyandroid.data.remote.model

import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "exchange", strict = false)
data class ExchangeResponse(
    @field:ElementList(name = "currency", inline = true)
    var currency: List<CurrencyResponse>? = null
)
