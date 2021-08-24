package com.example.tictoctie

import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.fragment.app.Fragment
import com.example.tictoctie.databinding.FragmentSettingsBinding
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.fragment_settings.*


class SettingsFragment : Fragment() {
  private lateinit var binding: FragmentSettingsBinding




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSettingsBinding.inflate(inflater, container, false)

        binding.switch1.setOnCheckedChangeListener { _, isChesked ->
            if (isChesked) {
                (requireActivity() as MainActivity).mediaPlayer?.stop()

            } else {
                (requireActivity() as MainActivity).mediaPlayer?.start()

                Log.d("Setting", "onCreateView: $isChesked")

            }
        }

        requireActivity().toolbar.setNavigationIcon(R.drawable.ic_back)
        requireActivity().toolbar.setNavigationOnClickListener {
            requireActivity().onBackPressed()

        }
return binding.root
        }


}