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

class ListFragment : Fragment(R.layout.list_fragment) {
    private var _binding : ListFragmentBinding? = null
    private val binding get() = _binding!!
    private val properties = HashMap<String, List<Category>>()
    private val myAdapter: MyListAdapter = MyListAdapter()

    init {
        properties.put("a", mutableListOf(Category("a"), Category("a"), Category("a")))
        properties.put("b", mutableListOf(Category("b"), Category("b"), Category("b")))
        properties.put("c", mutableListOf(Category("c"), Category("c"), Category("c")))
        properties.put("d", mutableListOf(Category("d"), Category("d"), Category("d")))
        properties.put("e", mutableListOf(Category("e"), Category("e"), Category("e")))
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        _binding = ListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.recyclerList.apply {
            adapter = myAdapter
            layoutManager = LinearLayoutManager(view.context)
        }

        myAdapter.submitList(properties["a"])

        super.onViewCreated(view, savedInstanceState)
    }

    fun onItemPressed(name : String) {
        myAdapter.submitList(properties.get(name))
    }
}