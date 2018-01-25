package com.example.daggertesting

class MyTestApp: MyApp() {

    public fun setInjector() {
        activityInjector = null
    }
}