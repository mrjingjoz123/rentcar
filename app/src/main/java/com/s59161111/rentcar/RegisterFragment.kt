package com.s59161111.rentcar


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
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
        return binding.root
    }


}
