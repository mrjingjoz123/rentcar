package com.s59161111.rentcar.home


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
import com.s59161111.rentcar.databinding.FragmentHomeBinding



class LoginFragment : Fragment() {
        private lateinit var binding : FragmentHomeBinding
        private lateinit var viewModel : HomeViewModel

        override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
           binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false)

            viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
            binding.homeViewModel = viewModel
            binding.lifecycleOwner = this



            viewModel.eventClickGo.observe(this, Observer { it ->
                if(it){
                    Log.i("GoViewModel","Go")
                    this.findNavController().navigate(R.id.action_homeFragment_to_rentFragment)
                }
            })

            viewModel.eventAbout.observe(this, Observer { it ->
                if(it){
                    Log.i("GoViewModel","About")
                    this.findNavController().navigate(R.id.action_homeFragment_to_aboutFragment)
                }
            })





        return binding.root
    }


}
