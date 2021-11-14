package com.example.hw2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hw2.fragment.ItemClickListener
import com.example.hw2.fragment.ListFragment

class MainActivity : AppCompatActivity(), ItemClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onItemClicked(item: String) {
        (supportFragmentManager.findFragmentByTag(
            "tag_list"
        ) as? ListFragment)?.onItemPressed(item)
    }
}