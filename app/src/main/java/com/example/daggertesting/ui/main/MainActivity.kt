package com.example.daggertesting.ui.main

import android.arch.lifecycle.ViewModelProvider
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.example.daggertesting.R
import com.example.daggertesting.ui.details.DetailsActivity
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = viewModelFactory.create(MainActivityViewModel::class.java)

        button.setOnClickListener {
            val intent = Intent(this, DetailsActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()

        Handler().postDelayed({
            runOnUiThread({
                textView.visibility = View.VISIBLE
                textView.text = viewModel.fetchDataFromService()
            })
        }, 2000)
    }
}
