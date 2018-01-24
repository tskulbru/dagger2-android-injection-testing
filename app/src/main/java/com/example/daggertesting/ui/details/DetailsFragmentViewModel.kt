package com.example.daggertesting.ui.details

import android.arch.lifecycle.ViewModel
import com.example.daggertesting.data.RealService
import javax.inject.Inject

class DetailsFragmentViewModel @Inject constructor(private val service: RealService) : ViewModel() {
    fun loadMoreDataFromService(): String {
        return service.loadMoreData()
    }
}