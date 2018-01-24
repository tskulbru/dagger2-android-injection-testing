package com.example.daggertesting.di

import com.example.daggertesting.ui.details.DetailsActivity
import com.example.daggertesting.ui.details.DetailsFragmentProvider
import com.example.daggertesting.ui.main.MainActivity
import com.example.daggertesting.ui.main.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [DetailsFragmentProvider::class])
    abstract fun bindDetailsActivity(): DetailsActivity
}