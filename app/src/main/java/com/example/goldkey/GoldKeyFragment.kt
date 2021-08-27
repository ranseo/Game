package com.example.goldkey

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.goldkey.databinding.FragmentGoldKeyBinding


class GoldKeyFragment : Fragment() {

    private lateinit var binding : FragmentGoldKeyBinding
    private val goldKeyViewModel by lazy {
        ViewModelProvider(this).get(GoldKeyViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_gold_key, container, false)


        return binding.root
    }
}