package com.example.daggertesting.ui.details

import dagger.Module
import dagger.android.ContributesAndroidInjector



@Module
abstract class DetailsFragmentProvider {
    @ContributesAndroidInjector(modules = [DetailsFragmentModule::class])
    abstract fun provideDetailFragmentFactory(): DetailsFragment
}