package com.example.hw2.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hw2.R
import com.example.hw2.adapter.ListAdapter
import com.example.hw2.databinding.ListFragmentBinding

class ListFragment : Fragment(R.layout.list_fragment) {
    private var _binding : ListFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        _binding = ListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.recyclerList.apply {
            adapter = ListAdapter(listOf("aaaaa", "bbbbbbbb", "cccccc", "dd", "eeeeeeeeeeeeeeeeeeeeeeeeeeee"))
            layoutManager = LinearLayoutManager(view.context)
        }

        super.onViewCreated(view, savedInstanceState)
    }
}