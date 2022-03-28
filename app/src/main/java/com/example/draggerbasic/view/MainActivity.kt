package com.example.draggerbasic.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.draggerbasic.R
import com.example.draggerbasic.databinding.ActivityMainBinding
import com.example.draggerbasic.viewModel.ListViewModel

class MainActivity : AppCompatActivity() {
    lateinit var  listViewModel:ListViewModel
    private val countriesAdapter = CountryListAdapter(arrayListOf())
    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main,)
        listViewModel = ListViewModel()
        binding.viewModel = listViewModel
        binding.viewModel?.refresh()

        binding.countriesList.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = countriesAdapter
        }
        observeViewModel()
    }

    fun observeViewModel(){
        binding.viewModel?.countries?.observe(this, Observer {
            it?.let{
                binding.countriesList.visibility  = View.VISIBLE
                countriesAdapter.updateCountries(it)
            }
        })

        binding.viewModel?.countryLoadError?.observe(this, Observer { isError ->
            isError?.let { binding.listError.visibility = if(it) View.VISIBLE else View.GONE }
        })

        binding.viewModel?.loading?.observe(this, Observer { isLoading ->
            isLoading?.let {
                binding.loadingView.visibility = if(it) View.VISIBLE else View.GONE
                if(it) {
                    binding.listError.visibility = View.GONE
                    binding.countriesList.visibility = View.GONE
                }
            }
        })
    }
}