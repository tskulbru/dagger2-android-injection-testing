package com.example.daggertesting.data

import javax.inject.Inject

class RealService @Inject constructor() {
    fun loadData(): String {
        return "This is not fake data"
    }

    fun loadMoreData(): String {
        return "This still isnt fake data"
    }
}