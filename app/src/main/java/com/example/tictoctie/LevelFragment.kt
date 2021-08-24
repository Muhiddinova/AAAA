package com.example.tictoctie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.GravityCompat
import androidx.navigation.fragment.findNavController
import com.example.tictoctie.databinding.FragmentLevelBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*


@Suppress("UNREACHABLE_CODE")
class LevelFragment : Fragment() {
    private lateinit var binding:FragmentLevelBinding



    override fun onCreateView(
        inflater: LayoutInflater,
        container1: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{

        binding= FragmentLevelBinding.inflate(inflater, container1, false)
        return binding.root


    }

    override fun onResume() {
        super.onResume()
        requireActivity().apply {
            app_bar.visibility = View.VISIBLE
            toolbar.visibility=View.VISIBLE
            toolbar.setNavigationOnClickListener {
                requireActivity().drawer_layout.openDrawer(GravityCompat.START)
            }
        }
        binding.level1.setOnClickListener {
            findNavController().navigate(R.id.game1Fragment)
        }
        binding.level2.setOnClickListener {
            findNavController().navigate(R.id.game2Fragment)
        }
        binding.level3.setOnClickListener {
            findNavController().navigate(R.id.game3Fragment)
        }
        binding.level4.setOnClickListener {
            findNavController().navigate(R.id.game4Fragment)
        }
        binding.level5.setOnClickListener {
            findNavController().navigate(R.id.game5Fragment)
        }
        binding.level6.setOnClickListener {
            findNavController().navigate(R.id.game6Fragment)
        }
        binding.level7.setOnClickListener {
            findNavController().navigate(R.id.game7Fragment)
        }
        binding.level8.setOnClickListener {
            findNavController().navigate(R.id.game8Fragment)
        }
        binding.level9.setOnClickListener {
            findNavController().navigate(R.id.game9Fragment)
        }
        binding.level10.setOnClickListener {
            findNavController().navigate(R.id.gameFragment)
        }


    }


}