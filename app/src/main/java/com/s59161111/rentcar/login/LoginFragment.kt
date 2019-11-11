package com.s59161111.rentcar.login


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.s59161111.rentcar.R
import com.s59161111.rentcar.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {
        private lateinit var binding :FragmentLoginBinding
        private lateinit var viewModel : LoginViewModel

        override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
           binding = DataBindingUtil.inflate(inflater,R.layout.fragment_login,container,false)

            viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
            binding.loginViewModel = viewModel
            binding.lifecycleOwner = this


            viewModel.eventGetInput.observe(this, Observer { it ->
                if(it){
                    viewModel.getInput(binding.LoginUser.text.toString() , binding.LoginPass.text.toString())
                }
            })

            viewModel.eventClickLogin.observe(this, Observer { it ->
                if(it){
                    Log.i("LoginViewModel","Press")
                    this.findNavController().navigate(R.id.action_loginFragment_to_rentFragment)
                }
            })

            viewModel.eventRegis.observe(this, Observer { it ->
                if(it){
                    Log.i("LoginViewModel","Register")
                    this.findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
                }
            })





        return binding.root
    }


}
