package com.example.beltexam2_rawanalanzi.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.beltexam2_rawanalanzi.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
//            BrowseAPIBTN.setOnClickListener{
//                startActivity(Int)
//            }
        }
    }
}