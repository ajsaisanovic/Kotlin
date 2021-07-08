package com.example.android.marsrealestate

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.android.marsrealestate.databinding.FragmentInformacijeBinding


class InformacijeFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentInformacijeBinding>(inflater,
                R.layout.fragment_informacije,container,false)
       binding.idButtonDalje.setOnClickListener{
           it.findNavController().navigate(R.id.action_informacijeFragment_to_overviewFragment2)
       }
        return binding.root
    }


}