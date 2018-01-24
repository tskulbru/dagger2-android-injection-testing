package com.example.daggertesting.ui.details

import android.os.Bundle
import com.example.daggertesting.R
import dagger.android.support.DaggerAppCompatActivity

class DetailsActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.container, DetailsFragment.newInstance())
                .commit()
        }
    }
}
