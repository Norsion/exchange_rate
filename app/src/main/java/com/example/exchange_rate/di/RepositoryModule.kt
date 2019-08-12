package com.example.exchange_rate.di

import com.example.exchange_rate.data.repository.BaseRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideBaseRepository(): BaseRepository {
        return BaseRepository()
    }
}