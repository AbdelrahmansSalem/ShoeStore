package com.example.android.shoestore.pages

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.android.shoestore.R
import com.example.android.shoestore.databinding.FragmentInstructionBinding
import com.example.android.shoestore.databinding.FragmentWelcomeBinding

class InstructionFragment : Fragment() {
lateinit var binding: FragmentInstructionBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_instruction, container, false)

        binding.myList.setOnClickListener(View.OnClickListener {
            it.findNavController().navigate(InstructionFragmentDirections.actionInstructionFragmentToListFragment())
        })
        return binding.root
    }


}