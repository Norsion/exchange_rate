package com.example.exchange_rate.di

import com.example.exchange_rate.UI.login.LogInFragment
import com.example.exchange_rate.UI.login.StartActivity
import com.example.exchange_rate.UI.main.MainFragment
import com.example.exchange_rate.data.repository.BaseRepository
import dagger.Component
import javax.inject.Singleton

@Component(modules = arrayOf(ProviderModule::class, RepositoryModule::class))
@Singleton
interface AppComponent {

    fun inject(baseRepository: BaseRepository)


}