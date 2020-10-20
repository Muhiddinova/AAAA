package com.example.tictoctie

import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tictoctie.databinding.FragmentSettingsBinding
import kotlinx.android.synthetic.main.content_main.*

class SettingsFragment : Fragment() {
  private lateinit var binding: FragmentSettingsBinding




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSettingsBinding.inflate(inflater, container, false)
        requireActivity().toolbar.setNavigationIcon(R.drawable.ic_back)
        requireActivity().toolbar.setNavigationOnClickListener {
            requireActivity().onBackPressed()

        }

        return binding.root
    }
}