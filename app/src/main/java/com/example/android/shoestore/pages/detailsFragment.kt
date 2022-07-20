package com.example.android.shoestore.pages

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.android.shoestore.R
import com.example.android.shoestore.databinding.FragmentDetailsBinding

class detailsFragment : Fragment() {
    lateinit var viewModel: ListViewModel
    lateinit var binding:FragmentDetailsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_details, container, false)

        viewModel= ViewModelProvider(requireActivity()).get(ListViewModel::class.java)

        binding.listViewModel=viewModel
        binding.setLifecycleOwner (this)


        binding.cancelButton.setOnClickListener(View.OnClickListener{
            it.findNavController().navigate(detailsFragmentDirections.actionDetailsFragmentToListFragment())
        })

        binding.saveButton.setOnClickListener(View.OnClickListener{
            if(binding.shoeNameEdit.text.toString().isEmpty() || binding.companyEdit.text.toString().isEmpty() ||binding.shoeSizeEdit.text.toString().isEmpty()||binding.descriptionEdit.text.toString().isEmpty()){
                Toast.makeText(context,"Fiil all feilds,Please",Toast.LENGTH_LONG).show()
            }
            else
            {
                viewModel.setshoe()
                it.findNavController().navigate(detailsFragmentDirections.actionDetailsFragmentToListFragment())
            }
        })


        return binding.root
    }



}