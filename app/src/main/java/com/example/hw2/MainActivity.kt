package com.example.hw2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.hw2.databinding.ActivityMainBinding
import com.example.hw2.fragment.*

class MainActivity : AppCompatActivity(), ItemClickListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onItemClicked(id: Int) {
        (supportFragmentManager.findFragmentByTag(
            "tag_list"
        ) as? ListFragment)?.onItemPressed(id)
    }
}