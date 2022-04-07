package osmanov.example.mvicurrencyandroid.di

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import osmanov.example.mvicurrencyandroid.BuildConfig
import osmanov.example.mvicurrencyandroid.data.remote.ApiRepository
import osmanov.example.mvicurrencyandroid.data.remote.ApiRepositoryContract
import osmanov.example.mvicurrencyandroid.data.remote.service.ApiService
import retrofit2.Retrofit
import retrofit2.SimpleXmlConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Module for Network dependency. Like [Retrofit], [OkHttpClient], [ApiService] ...
 */
val networkModule = module {
    factory { provideOkHttpClient() }
    factory { provideRetrofit(get()) }
    single { provideServiceApi(get()) }
    single<ApiRepositoryContract> { ApiRepository(get(), get()) }
}

private val loggingInterceptor = HttpLoggingInterceptor().apply {
    level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
    else HttpLoggingInterceptor.Level.NONE
}

private fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder().apply {
        connectTimeout(30, TimeUnit.SECONDS)
        readTimeout(30, TimeUnit.SECONDS)
        addInterceptor(loggingInterceptor)
    }.build()
}

private fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(SimpleXmlConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .client(okHttpClient)
        .build()
}

private fun provideServiceApi(retrofit: Retrofit): ApiService =
    retrofit.create(ApiService::class.java)
