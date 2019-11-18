package com.s59161111.rentcar.detail



import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.s59161111.rentcar.R
import com.s59161111.rentcar.databinding.FragmentDetailBinding
import com.s59161111.rentcar.rent.x
import kotlinx.android.synthetic.main.fragment_detail.*


/**
 * A simple [Fragment] subclass.
 */
class DetailFragment : Fragment() {
    private lateinit var binding : FragmentDetailBinding
    private lateinit var viewModel :DetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_detail,container,false)

        viewModel = ViewModelProviders.of(this).get(DetailViewModel::class.java)
        binding.detailViewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.eventClickBack.observe(this, Observer { it ->
            if(it){
                Log.i("DetailViewModel","Back")
                this.findNavController().navigate(R.id.action_detailFragment_to_rentFragment)
            }
        })

        if (x==1){
            Log.i("DetailViewModel","1")

        }else if (x == 2){
            Log.i("DetailViewModel","2")

        }





        return binding.root
    }

}



