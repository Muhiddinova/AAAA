package com.example.tictoctie


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.tictoctie.databinding.FragmentPlayBinding
import com.idrok.dars2.GameViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*


@Suppress("UNREACHABLE_CODE")
class PlayFragment : Fragment() {
    private lateinit var binding: FragmentPlayBinding
    private lateinit var viewModel: GameViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container1: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPlayBinding.inflate(inflater, container1, false)
        viewModel=ViewModelProviders.of(requireActivity()).get(GameViewModel::class.java)
        viewModel.setListText(arrayListOf())
           // startSound()
//        val mediaPlayer1 = mediaPlayer: MediaPlayer? = MediaPlayer.create(context, R.raw.click)
//        mediaPlayer?.start()
        return binding.root

    }


    override fun onResume() {
        super.onResume()
        requireActivity().apply {
            app_bar.visibility = View.GONE
            toolbar.visibility=View.VISIBLE
            toolbar.setNavigationOnClickListener {
                requireActivity().drawer_layout.openDrawer(GravityCompat.START)
            }
        }
        binding.apply {
            btnPlayGame.setOnClickListener {
                findNavController().navigate(R.id.levelFragment)}
            btnSetting.setOnClickListener{
                findNavController().navigate(R.id.settingsFragment) }
            btnInfo.setOnClickListener{
                findNavController().navigate(R.id.infoFragment)
            }
            btnMoreApp.setOnClickListener {
                var intent=Intent()
                intent = Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.example.tictoctie"))
                startActivity(intent)
            }


        }

    }


}



