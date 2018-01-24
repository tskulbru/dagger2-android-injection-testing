package com.example.daggertesting.ui.main

import android.arch.lifecycle.ViewModel
import com.example.daggertesting.data.RealService
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(private val service: RealService) : ViewModel() {
    // Would probably want to use livedata in real life though
    fun fetchDataFromService(): String {
        return service.loadData()
    }
}