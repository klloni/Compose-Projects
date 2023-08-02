package com.klloni.viewmodeldemo1

import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
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
//            viewModel.setValue(binding.etValue.text.toString().toIntOrNull() ?: 0)
            val inputText = binding.etValue.text.toString()
            if (inputText.isNotBlank()) {
                viewModel.setValue(inputText.toInt())
            } else {
                Toast.makeText(this, "Enter value..", Toast.LENGTH_SHORT).show()
                viewModel.setValue(0)
            }
            binding.textValue.text = viewModel.getValue().toString()
            binding.etValue.text.clear()
            val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
        }
    }
}