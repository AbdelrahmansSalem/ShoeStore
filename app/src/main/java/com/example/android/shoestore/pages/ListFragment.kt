package com.example.android.shoestore.pages

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.android.shoestore.R
import com.example.android.shoestore.databinding.FragmentInstructionBinding
import com.example.android.shoestore.databinding.FragmentListBinding


class ListFragment : Fragment() {

lateinit var binding: FragmentListBinding
lateinit var viewModel: ListViewModel
    lateinit var layout:LinearLayout
    val params = LinearLayout.LayoutParams(
        LinearLayout.LayoutParams.MATCH_PARENT,
        LinearLayout.LayoutParams.MATCH_PARENT,

        )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_list, container, false)

        layout=binding.myList



        viewModel=ViewModelProvider(requireActivity()).get(ListViewModel::class.java)

        viewModel.list.observe(viewLifecycleOwner, Observer {name->
            addview()
        })
        binding.addItem.setOnClickListener(View.OnClickListener {
            it.findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailsFragment())
        })


        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.logout -> navigate()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun navigate() {
        findNavController().navigate(ListFragmentDirections.actionListFragmentToLoginFragment())
    }

    fun addview(){
        for (x in viewModel.list.value!!) {
            var text = TextView(context)
            text.text = x.name
            text.textSize= 20F
            text.setTextColor( Color.RED)
            text.gravity=Gravity.CENTER_HORIZONTAL
            layout.addView(text)

        }
    }

}