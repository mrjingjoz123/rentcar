package com.s59161111.rentcar.detail



import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.s59161111.rentcar.R
import com.s59161111.rentcar.database.Book
import com.s59161111.rentcar.database.BookDatabase
import com.s59161111.rentcar.databinding.FragmentDetailBinding
import com.s59161111.rentcar.rent.x
import kotlinx.android.synthetic.main.fragment_detail.*



class DetailFragment : Fragment() {
    private lateinit var binding : FragmentDetailBinding
    private lateinit var viewModel :DetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_detail,container,false)

        val safeArgs = DetailFragmentArgs.fromBundle(arguments!!)

        val application = requireNotNull(this.activity).application
        val dataSource = BookDatabase.getInstance(application).BookDatabaseDao
        val viewModelFactory = DetailViewModelFactory(dataSource, application)

        viewModel = ViewModelProviders.of(this,viewModelFactory).get(DetailViewModel::class.java)
        binding.detailViewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.Init.observe(this, Observer { it ->
            if(it){
                if(safeArgs.bicycle == 1){
                    binding.imagePicture.setImageDrawable(resources.getDrawable(R.drawable.bike1))
                    viewModel.getSafe(1)

                }else if(safeArgs.bicycle == 2){
                    binding.imagePicture.setImageDrawable(resources.getDrawable(R.drawable.bike2))
                    viewModel.getSafe(2)
                }

            }
        })

        viewModel.eventClickBack.observe(this, Observer { it ->
            if(it){
                Log.i("DetailViewModel","Back")
                this.findNavController().navigate(R.id.action_detailFragment_to_rentFragment)
            }
        })

        viewModel.eventClickSave.observe(this, Observer { it ->
            if(it){
                Log.i("DetailViewModel","Save")
                this.findNavController().navigate(R.id.action_detailFragment_to_rentFragment)
            }
        })

        viewModel.eventCheckInput.observe(this, Observer { it ->
            if(it){
                viewModel.ClickPress(binding.textInputEditText.toString())
            }
        })

        viewModel.popUp.observe(this, Observer { it ->
            if(it){
                Log.i("Test","!!")
                Toast.makeText(activity, "Input your name", Toast.LENGTH_LONG).show()
                viewModel._popUp.value = false
            }
        })

        return binding.root
    }

}



