package com.example.pokeapi.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.pokeapi.databinding.ActivityMainBinding
import androidx.fragment.app.replace
import com.example.pokeapi.R
import com.example.pokeapi.view.fragment.PokemonFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
   // lateinit var viewModel: MainViewModel
   // private val retrofitAPI = RetrofitAPI.getInstanceRetrofit()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //viewModel = ViewModelProvider(this, MainViewModelFactory(MainRepository(retrofitAPI)))[MainViewModel::class.java]
       // viewModel.getPokeViewModel()
        var namePokemon =

       binding.btFindPokemon.setOnClickListener {
           initFragment()
       }
    }

    private fun initFragment() {
        val bundle = bundleOf(
            "namePokemon" to binding.editName.text.toString()
        )

        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace<PokemonFragment>(R.id.fragmentView, args = bundle)
        }
    }


}