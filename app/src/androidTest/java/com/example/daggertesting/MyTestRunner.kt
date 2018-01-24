package com.example.daggertesting

import android.app.Application
import android.content.Context
import android.support.test.runner.AndroidJUnitRunner

class MyTestRunner: AndroidJUnitRunner() {
    override fun newApplication(cl: ClassLoader, className: String, context: Context): Application {
        return super.newApplication(cl, MyTestApp::class.java.name, context)
    }
}