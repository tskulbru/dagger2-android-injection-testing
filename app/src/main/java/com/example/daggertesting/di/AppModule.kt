package com.example.daggertesting.di

import android.app.Application
import android.content.Context
import com.example.daggertesting.MyApp
import dagger.Module
import javax.inject.Singleton
import dagger.Provides

@Module
class AppModule {
    @Provides
    @Singleton
    internal fun provideContext(application: MyApp): Context {
        return application
    }
}