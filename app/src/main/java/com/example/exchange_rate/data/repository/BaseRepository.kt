package com.example.exchange_rate.data.repository

import android.util.Log
import com.example.exchange_rate.App
import com.example.exchange_rate.data.model.Base
import com.example.exchange_rate.data.model.Rate
import com.example.partytask.data.network.ApiClient
import com.example.partytask.data.network.ApiService
import io.reactivex.Single
import javax.inject.Inject

class BaseRepository :IBaseRepository{

    //@Inject lateinit
    var service: ApiService = ApiClient.instance.apiService

    override fun getBase(): Single<Base> {
        //App.appComponent.inject(this)
        return service.getBase()

    }

}