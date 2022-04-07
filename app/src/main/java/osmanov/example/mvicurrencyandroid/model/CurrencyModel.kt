package osmanov.example.mvicurrencyandroid.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CurrencyModel(
    val id: Long,
    val name: String,
    val code: String,
    val rate: Double,
    val exchangeDate: String
) : Parcelable
