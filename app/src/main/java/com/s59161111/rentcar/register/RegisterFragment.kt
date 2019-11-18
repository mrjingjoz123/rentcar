package com.s59161111.rentcar.register


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.s59161111.rentcar.R
import com.s59161111.rentcar.databinding.FragmentLoginBinding
import com.s59161111.rentcar.databinding.FragmentRegisterBinding
import com.s59161111.rentcar.login.LoginViewModel

/**
 * A simple [Fragment] subclass.
 */
class RegisterFragment : Fragment() {
    private lateinit var binding : FragmentRegisterBinding
    private lateinit var viewModel : RegisterViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_register,container,false)

        viewModel = ViewModelProviders.of(this).get(RegisterViewModel::class.java)
        binding.registerViewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.eventClickBack.observe(this, Observer { it ->
            if(it){
                Log.i("RegisterViewModel","Back")
                this.findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
            }
        })

        viewModel.eventGetInput.observe(this, Observer { it ->
            if(it){
                viewModel.getInput(binding.ReUser.text.toString() , binding.RePass.text.toString(),binding.ReEmail.text.toString(),binding.RePhone.text.toString())
            }
        })
        viewModel.eventClickSave.observe(this, Observer { it ->
            if(it){
                Log.i("RegisterViewModel","Success")
                this.findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
            }
        })






        return binding.root
    }


}
