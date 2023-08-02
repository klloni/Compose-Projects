package com.klloni.viewmodeldemo1

import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.klloni.viewmodeldemo1.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]

        binding.textValue.text = viewModel.getValue().toString()

        binding.button.setOnClickListener {
            viewModel.setValue(binding.etValue.text.toString().toInt())
            binding.textValue.text = viewModel.getValue().toString()
            binding.etValue.text.clear()
            val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
        }


        /*binding.countText.text = viewModel.getCurrentCount().toString()
        binding.button.setOnClickListener {
            viewModel.getUpdatedCount()
            binding.countText.text = viewModel.getCurrentCount().toString()
        }*/
    }
}