package osmanov.example.mvicurrencyandroid.data.remote.model

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "currency", strict = false)
data class CurrencyResponse(
    @field:Element(name = "r030")
    var id: Long = 0,
    @field:Element(name = "txt")
    var name: String = "",
    @field:Element(name = "rate")
    var rate: Double = 0.toDouble(),
    @field:Element(name = "cc")
    var code: String = "",
    @field:Element(name = "exchangedate")
    var exchangeDate: String = ""
)
