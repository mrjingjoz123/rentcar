package com.s59161111.rentcar.rent


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.s59161111.rentcar.R
import com.s59161111.rentcar.databinding.FragmentRentBinding

/**
 * A simple [Fragment] subclass.
 */
class RentFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentRentBinding>(inflater,
            R.layout.fragment_rent,container,false)

        binding.RentBack.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_rentFragment_to_loginFragment)
        }
        binding.imageButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_rentFragment_to_detailFragment)
        }
        return binding.root
    }


}
