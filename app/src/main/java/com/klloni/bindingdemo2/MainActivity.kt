package com.klloni.bindingdemo2

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.klloni.bindingdemo2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.controlButton.setOnClickListener {
            startOrStopProgressBar()
        }
    }

    private fun startOrStopProgressBar() {
        val progressBar = binding.progressBar
        val button = binding.controlButton
        if (progressBar.visibility == View.GONE) {
            progressBar.visibility = View.VISIBLE
            button.text = "Stop"
        } else {
            progressBar.visibility = View.GONE
            button.text = "Start"
        }
    }
}