package com.example.exchange_rate.di

import com.example.exchange_rate.BuildConfig
import com.example.partytask.data.network.ApiClient
import com.example.partytask.data.network.ApiService
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class ProviderModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient().newBuilder().apply {
            readTimeout(10, TimeUnit.SECONDS)
            connectTimeout(5, TimeUnit.SECONDS)
            if (BuildConfig.DEBUG) {
                val interceptor = HttpLoggingInterceptor()
                interceptor.level = HttpLoggingInterceptor.Level.BODY
                addInterceptor(interceptor)
            }
        }.build()

    }

    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.ratesapi.io/api/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(provideOkHttpClient())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(): ApiService {
        var service: ApiService = provideRetrofit().create(ApiService::class.java)
        return service
    }

    /*@Provides
    @Singleton
    fun provideApiClient(): ApiClient {
        val client = ApiClient()
        client.apiService = provideApiService()
        return client
    }*/


}