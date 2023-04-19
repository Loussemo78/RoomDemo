package com.example.roomdemo

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdemo.databinding.ActivityMainBinding
import com.example.roomdemo.views.WordListAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapter = WordListAdapter()
        binding.recyclerview.adapter = adapter
        binding.recyclerview.layoutManager


    }
}