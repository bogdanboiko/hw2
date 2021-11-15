package com.example.hw2.fragment

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL
import com.example.hw2.R
import com.example.hw2.adapter.MenuAdapter
import com.example.hw2.databinding.MenuFragmentBinding
import com.example.hw2.model.CategoryData

interface ItemClickListener {
    fun onItemClicked(id: Int)
}

class MenuFragment : Fragment(R.layout.menu_fragment) {
    private lateinit var binding : MenuFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = MenuFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.recyclerMenu.apply {
            adapter = MenuAdapter(CategoryData.getCategories(), requireActivity() as ItemClickListener)

            layoutManager =
                if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
                    LinearLayoutManager(view.context, HORIZONTAL, false)
                } else {
                    LinearLayoutManager(view.context)
                }
        }

        super.onViewCreated(view, savedInstanceState)
    }
}