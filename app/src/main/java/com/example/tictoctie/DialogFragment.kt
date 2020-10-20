package com.example.tictoctie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tictoctie.databinding.FragmentDialogBinding
import com.example.tictoctie.databinding.FragmentPlayBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class MyDialog : BottomSheetDialogFragment() {
    private lateinit var binding:FragmentDialogBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDialogBinding.inflate(inflater, container, false)
        return binding.root }
}
