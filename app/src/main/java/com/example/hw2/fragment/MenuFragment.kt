package com.example.hw2.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hw2.R
import com.example.hw2.adapter.MenuAdapter
import com.example.hw2.databinding.MenuFragmentBinding

interface ItemClickListener {
    fun onItemClicked(item: String)
}

class MenuFragment : Fragment(R.layout.menu_fragment) {
    private var _binding : MenuFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        _binding = MenuFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.recyclerMenu.apply {
            adapter = MenuAdapter(listOf("a", "b", "c", "d", "e"), requireActivity() as ItemClickListener)
            layoutManager = LinearLayoutManager(view.context)
        }

        super.onViewCreated(view, savedInstanceState)
    }
}