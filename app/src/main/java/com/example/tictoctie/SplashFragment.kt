package com.example.tictoctie

import android.os.Bundle
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.postDelayed
import androidx.navigation.fragment.findNavController
import com.example.tictoctie.databinding.FragmentSplashBinding
import kotlinx.android.synthetic.main.content_main.*
import java.util.*


class SplashFragment : Fragment(){

    private lateinit var timer: Timer


    private lateinit var binding:FragmentSplashBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSplashBinding.inflate(inflater,container,false)
       requireActivity().app_bar.visibility=View.GONE
        return binding.root
    }

    private fun waitAndOpenOtherFragment(){
        timer = Timer()
        timer.schedule(object : TimerTask(){
            override fun run() {
                findNavController().navigate(R.id.mainFragment)
            }
        },2000)
    }


    override fun onResume() {
        super.onResume()
        waitAndOpenOtherFragment()
    }
}


