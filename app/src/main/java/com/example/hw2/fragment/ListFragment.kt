package com.example.hw2.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hw2.R
import com.example.hw2.adapter.MyListAdapter
import com.example.hw2.databinding.ListFragmentBinding
import com.example.hw2.model.Category
import com.example.hw2.model.CategoryData

class ListFragment : Fragment(R.layout.list_fragment) {
    private lateinit var binding : ListFragmentBinding
    private val properties = HashMap<Int, Category>()
    private val myAdapter: MyListAdapter = MyListAdapter()
    private var currentId: Int = 1

    init {
        for (category in CategoryData.getCategories()) {
            properties.put(category.id, category)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = ListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.recyclerList.apply {
            adapter = myAdapter
            layoutManager = LinearLayoutManager(view.context)
        }

        if (savedInstanceState != null) {
            currentId = savedInstanceState.getInt("id")
        }

        myAdapter.submitList(properties[currentId]?.subItems)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("id", currentId)
        super.onSaveInstanceState(outState)
    }

    fun onItemPressed(id : Int) {
        currentId = id
        myAdapter.submitList(properties[id]?.subItems)
    }
}