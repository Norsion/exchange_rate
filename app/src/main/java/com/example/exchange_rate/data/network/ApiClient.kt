package com.example.partytask.data.network



import com.example.exchange_rate.BuildConfig
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class ApiClient {
    private object Holder {
        val instance = ApiClient()
    }

    companion object {
        val instance: ApiClient by lazy { Holder.instance }
    }


    val apiService:ApiService

    init {

        apiService = createRetrofit("https://api.ratesapi.io/api/", initOkHttpClient()).create(ApiService::class.java)
    }

    //уровень подключения
    private fun initOkHttpClient(): OkHttpClient {
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



    private fun createRetrofit(baseUrl: String, client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}