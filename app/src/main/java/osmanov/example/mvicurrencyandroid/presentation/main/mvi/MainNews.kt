package osmanov.example.mvicurrencyandroid.presentation.main.mvi

import osmanov.example.mvicurrencyandroid.common.mvi.News

sealed class MainNews : News {

    data class Message(val duration: Int, val content: String) : MainNews()

}
