package com.example.tictoctie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tictoctie.databinding.FragmentInfoBinding
import kotlinx.android.synthetic.main.content_main.*


class InfoFragment : Fragment() {
    private lateinit var binding: FragmentInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInfoBinding.inflate(inflater, container, false)
        requireActivity().toolbar.setNavigationIcon(R.drawable.ic_back)
        requireActivity().toolbar.setNavigationOnClickListener {
            requireActivity().onBackPressed()

        }

    return binding.root}
}