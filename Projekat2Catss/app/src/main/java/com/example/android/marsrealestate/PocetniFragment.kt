package com.example.android.marsrealestate

import android.os.Bundle
import android.view.*
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.marsrealestate.databinding.FragmentPocetniBinding


class PocetniFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentPocetniBinding>(inflater,
                R.layout.fragment_pocetni,container,false)
        setHasOptionsMenu(true)
        binding.idButtonUdomi.setOnClickListener{
            it.findNavController().navigate(R.id.action_pocetniFragment_to_informacijeFragment)
        }
        return binding.root
    }




}