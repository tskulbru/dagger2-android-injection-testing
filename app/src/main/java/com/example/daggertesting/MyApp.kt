package com.example.daggertesting

import com.example.daggertesting.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class MyApp : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<MyApp> {
        return DaggerAppComponent.builder().create(this)
    }
}