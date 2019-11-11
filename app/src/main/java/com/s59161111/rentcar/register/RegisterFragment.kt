package com.s59161111.rentcar.register


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.s59161111.rentcar.R
import com.s59161111.rentcar.databinding.FragmentRegisterBinding

/**
 * A simple [Fragment] subclass.
 */
class RegisterFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentRegisterBinding>(inflater,
            R.layout.fragment_register,container,false)

        binding.ReBack.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }
        val application = requireNotNull(this.activity).application

        return binding.root
    }


}
