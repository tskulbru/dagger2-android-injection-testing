package com.example.daggertesting.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.daggertesting.ui.details.DetailsFragmentViewModel
import com.example.daggertesting.ui.main.MainActivityViewModel
import com.example.daggertesting.util.MyViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: MyViewModelFactory): ViewModelProvider.Factory

    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    @Binds
    abstract fun bindLoginRegistrationViewModel(viewModel: MainActivityViewModel): ViewModel

    @IntoMap
    @ViewModelKey(DetailsFragmentViewModel::class)
    @Binds
    abstract fun bindDetailsFragmentViewModel(viewModel: DetailsFragmentViewModel): ViewModel
}