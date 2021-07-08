package com.example.android.marsrealestate

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.android.marsrealestate.databinding.FragmentPodaciBinding


class PodaciFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentPodaciBinding>(inflater,
                R.layout.fragment_podaci,container,false)
        binding.idButtonPosaljiInfo.setOnClickListener{
            val ime=binding.idEditIme.text.toString()
            val prezime=binding.idEditPrezime.text.toString()
            val grad=binding.idEditGrad.text.toString()
            val broj=binding.idEditBroj.text.toString()
            it.findNavController().navigate(PodaciFragmentDirections.actionPodaciFragmentToKrajFragment(ime,prezime,broj))
        }

        return binding.root
    }


}