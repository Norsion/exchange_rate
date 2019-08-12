package com.example.exchange_rate.data.repository

import com.example.exchange_rate.data.model.Base
import io.reactivex.Single

interface IBaseRepository{

    fun getBase(): Single<Base>

}