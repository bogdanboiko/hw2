package com.example.hw2

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.findFragment
import com.example.hw2.databinding.ActivityMainBinding
import com.example.hw2.fragment.*

class MainActivity : AppCompatActivity(R.layout.activity_main), ItemClickListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().apply {
            replace(binding.itemsContainer.id, MenuFragment())
            replace(binding.listContainer.id, ListFragment(), "tag_list")
            commit()
        }
    }

    override fun onItemClicked(item: String) {
        (supportFragmentManager.findFragmentByTag(
            "tag_list"
        ) as? ListFragment)?.onItemPressed(item)
    }
}