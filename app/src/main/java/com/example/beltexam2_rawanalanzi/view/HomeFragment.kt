package com.example.beltexam2_rawanalanzi.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.beltexam2_rawanalanzi.R
import com.example.beltexam2_rawanalanzi.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding:FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentHomeBinding.inflate(layoutInflater)
        binding.apply {
            BrowseAPIBTN.setOnClickListener {
                android.util.Log.d("TAG", "onCreateView: ")
//                Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_APIFragment)
                openAPIFragment()
//                findNavController().navigate(R.id.action_homeFragment_to_APIFragment)
            }
            LocalBTN.setOnClickListener {
                openRoomFragment()
            }
        }
        return binding.root
    }

    private fun openRoomFragment() {
//        findNavController().navigate(R.id.action_APIFragment_to_roomFragment)
    }

    private fun openAPIFragment() {

        findNavController().navigate(R.id.action_homeFragment_to_APIFragment)
    }


}