package com.example.exchange_rate

import android.app.Application
import com.example.exchange_rate.di.AppComponent
import com.example.exchange_rate.di.DaggerAppComponent
import com.example.exchange_rate.di.ProviderModule
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.NavigatorHolder



class App : Application() {
/*
    private lateinit var cicerone: Cicerone<Router>


    override fun onCreate() {
        super.onCreate()
        instance = this
        appComponent = DaggerAppComponent.builder()
            .providerModule(ProviderModule())
            .build()
        initDagger()
        initCicerone()

    }
    companion object {
        lateinit var instance: App
        lateinit var appComponent: AppComponent
    }

    private fun initCicerone() {
        this.cicerone = Cicerone.create()
    }
    private fun initDagger(){
        appComponent = DaggerAppComponent.builder()
            .providerModule(ProviderModule())
            .build()
    }
    fun getNavigatorHolder(): NavigatorHolder {
        return cicerone.navigatorHolder
    }

    fun getRouter(): Router {
        return cicerone.router
    }*/
}