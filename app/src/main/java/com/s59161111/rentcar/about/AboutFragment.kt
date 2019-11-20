package com.s59161111.rentcar.about


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
import com.s59161111.rentcar.databinding.FragmentAboutBinding


/**
 * A simple [Fragment] subclass.
 */
class AboutFragment : Fragment() {
    private lateinit var binding : FragmentAboutBinding
    private lateinit var viewModel : AboutViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_about,container,false)

        viewModel = ViewModelProviders.of(this).get(AboutViewModel::class.java)
        binding.aboutViewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.eventClickBack.observe(this, Observer { it ->
            if(it){
                Log.i("AboutViewModel","Back")
                this.findNavController().navigate(R.id.action_aboutFragment_to_homeFragment)
            }
        })

        return binding.root
    }


}
