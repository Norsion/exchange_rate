package com.example.partytask.data.network


import com.example.exchange_rate.data.model.Base
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService{

    @GET("latest")
    fun getBase(): Single<Base>

}