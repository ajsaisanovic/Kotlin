package com.example.android.marsrealestate

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.android.marsrealestate.databinding.FragmentKrajBinding

import android.view.*
import androidx.navigation.fragment.navArgs


import java.util.*



class KrajFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    private val args: KrajFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding = DataBindingUtil.inflate<FragmentKrajBinding>(inflater,
                R.layout.fragment_kraj,container,false)
        val ime_prezime=args.ime +" "+ args.prezime
        val tekst=" hvala Vam na interesovanju za udomljavanjem, uskoro ćemo vam se javiti za dodatne informacije."
        binding.idUnesi.setText(ime_prezime+tekst)

        return binding.root
    }


}