package com.example.tictoctie

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.tictoctie.databinding.FragmentInfoBinding
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.fragment_info.*


class InfoFragment : Fragment() {
    private lateinit var binding: FragmentInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        binding = FragmentInfoBinding.inflate(inflater, container, false)
        binding.tvUsername.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/bmb717420"))
            startActivity(intent)
        }
        requireActivity().toolbar.setNavigationIcon(R.drawable.ic_back)
        requireActivity().toolbar.setNavigationOnClickListener {
           findNavController().navigate(R.id.action_infoFragment_to_mainFragment)
        }

    return binding.root}
}