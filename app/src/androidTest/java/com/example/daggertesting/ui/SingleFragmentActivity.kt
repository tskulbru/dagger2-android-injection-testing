package com.example.daggertesting.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.ViewGroup
import android.widget.FrameLayout
import com.example.daggertesting.R
import dagger.android.support.DaggerAppCompatActivity

open class SingleFragmentActivity: DaggerAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val content = FrameLayout(this)
        content.layoutParams = FrameLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT)
        content.id = R.id.container
        setContentView(content)
    }

    fun setFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .add(R.id.container, fragment, "Test")
            .commitAllowingStateLoss()
    }
}