package com.s59161111.rentcar.rent


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.s59161111.rentcar.R
import com.s59161111.rentcar.databinding.FragmentRentBinding


/**
 * A simple [Fragment] subclass.
 */
public var x = 0;

class RentFragment : Fragment() {
    private lateinit var binding : FragmentRentBinding
    private lateinit var viewModel : RentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_rent,container,false)

        viewModel = ViewModelProviders.of(this).get(RentViewModel::class.java)
        binding.rentViewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.eventClickBack.observe(this, Observer { it ->
            if(it){
                Log.i("RentViewModel","Back")

                this.findNavController().navigate(R.id.action_rentFragment_to_loginFragment)
            }
        })

        viewModel.eventClickPicture1.observe(this, Observer { it ->
            if(it){
                Log.i("RentViewModel","Picture1")
                x = 1
                this.findNavController().navigate(R.id.action_rentFragment_to_detailFragment)
            }
        })

        viewModel.eventClickPicture2.observe(this, Observer { it ->
            if(it){
                Log.i("RentViewModel","Picture2")
                x = 2
                this.findNavController().navigate(R.id.action_rentFragment_to_detailFragment)
            }
        })
        return binding.root
    }


}
