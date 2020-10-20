package com.example.tictoctie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tictoctie.databinding.FragmentPlayBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*


@Suppress("UNREACHABLE_CODE")
class PlayFragment : Fragment() {
    private lateinit var binding: FragmentPlayBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container1: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPlayBinding.inflate(inflater, container1, false)
        return binding.root

    }

    override fun onResume() {
        super.onResume()
        requireActivity().apply {
            app_bar.visibility = View.VISIBLE
            toolbar.setNavigationIcon(R.drawable.ic_menu)
            toolbar.setNavigationOnClickListener {
                requireActivity().drawer_layout.openDrawer(GravityCompat.START)
            }
        }
        binding.btnPlayGame.setOnClickListener {
            findNavController().navigate(R.id.gameFragment)
        }

    }


}



