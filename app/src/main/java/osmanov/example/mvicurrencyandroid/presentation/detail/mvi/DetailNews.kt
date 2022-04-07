package osmanov.example.mvicurrencyandroid.presentation.detail.mvi

import osmanov.example.mvicurrencyandroid.common.mvi.News
import osmanov.example.mvicurrencyandroid.presentation.main.mvi.MainNews

sealed class DetailNews : News {

    data class Message(val duration: Int, val content: String) : DetailNews()

}
