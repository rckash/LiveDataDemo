package com.example.databindingdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.databindingdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]

        // add observer
        viewModel.name.observe(this, Observer { name ->
            binding.tvName.text = name
        })

        viewModel.age.observe(this, Observer { age ->
            binding.tvAge.text = age.toString()
        })

        binding.btnSendData.setOnClickListener {
            viewModel.updateName(binding.etName.text.toString())
            viewModel.updateAge(binding.etAge.text.toString().toInt())
        }
    }
}