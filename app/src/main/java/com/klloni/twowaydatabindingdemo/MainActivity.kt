package com.klloni.twowaydatabindingdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.klloni.twowaydatabindingdemo.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var viewModelFactory: MainActivityViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModelFactory = MainActivityViewModelFactory(125)
        viewModel = ViewModelProvider(this, viewModelFactory)[MainActivityViewModel::class.java]

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        /*viewModel.totalData.observe(this, Observer {
            binding.textValue.text = it.toString()
        })*/


        /*   binding.button.setOnClickListener {
   //            viewModel.setValue(binding.etValue.text.toString().toIntOrNull() ?: 0)
               val inputText = binding.etValue.text.toString()
               if (inputText.isNotBlank()) {
                   viewModel.setValue(inputText.toInt())
               } else {
                   Toast.makeText(this, "Enter value..", Toast.LENGTH_SHORT).show()
                   viewModel.setValue(0)
               }
   //            binding.textValue.text = viewModel.getValue().toString()
               binding.etValue.text.clear()
               val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
               imm.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
           }*/
    }
}