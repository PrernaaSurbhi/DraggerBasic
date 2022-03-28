package com.example.draggerbasic.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.draggerbasic.databinding.CountryItemBinding
import com.example.draggerbasic.model.Country
import com.example.draggerbasic.util.getProgressDrawable
import com.example.draggerbasic.util.loadImage


/**
 * Created by PrernaSurbhi on 26/03/22.
 */
class CountryListAdapter(var countries: ArrayList<Country>) :
    RecyclerView.Adapter<CountryListAdapter.CountryViewHolder>() {

    fun updateCountries(newCountries: List<Country>) {
        countries.clear()
        countries.addAll(newCountries)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CountryItemBinding.inflate(inflater)
        return CountryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(countries[position])
    }

    override fun getItemCount(): Int {
        return countries.size;
    }

    class CountryViewHolder(var binding: CountryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val progressDrawable = getProgressDrawable(binding.root.context)

        fun bind(country: Country) {
            binding.name.text = country.countryName
            binding.capital.text  = country.capital
            binding.imageView.loadImage(country.flag,progressDrawable = progressDrawable)
        }
    }

}
