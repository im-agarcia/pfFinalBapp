package com.example.proyectofinalkotlin.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.proyectofinalkotlin.R


class MainFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btn_banapp_signin : Button = view.findViewById(R.id.btn_bandap_signin)
        btn_banapp_signin.setOnClickListener{
            findNavController().navigate(R.id.action_mainFragment_to_loginBandAppFragment)
        }

    }
}