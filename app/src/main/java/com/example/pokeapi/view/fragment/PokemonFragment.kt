package com.example.pokeapi.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.pokeapi.R
import com.example.pokeapi.repository.MainRepository
import com.example.pokeapi.retrofit.RetrofitAPI
import com.example.pokeapi.viewModel.MainViewModel
import com.example.pokeapi.viewModel.MainViewModelFactory
import com.squareup.picasso.Picasso


class PokemonFragment : Fragment(R.layout.fragment_pokemon) {
    lateinit var viewModel: MainViewModel
    private val retrofitAPI = RetrofitAPI.getInstanceRetrofit()
    private lateinit var picasso: com.example.pokeapi.picasso.Picasso


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        picasso = com.example.pokeapi.picasso.Picasso()
        viewModel = ViewModelProvider(this, MainViewModelFactory(MainRepository(retrofitAPI)))[MainViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        println("dentro do onViewCreated")
        val nameRecover = requireArguments().getString("namePokemon")

        val pokemonImage: ImageView = view.findViewById(R.id.imageView)
        val pokemonID: TextView = view.findViewById(R.id.idPokemon)
        val pokemonName: TextView = view.findViewById(R.id.namePokemon)
        val pokemonType: TextView = view.findViewById(R.id.typePokemon)
        val pokemonXP: TextView = view.findViewById(R.id.xpPokemon)

        viewModel.getPokemonMainViewModel(nameRecover.toString()).observe(viewLifecycleOwner, Observer {
            try {
                picasso.converImage(it.sprites.front_default, pokemonImage)
                pokemonID.setText("number"+it.id.toString())
                pokemonName.setText(it.name)
                pokemonXP.setText("XP: "+it.base_experience.toString())
                viewModel.typePoke.observe(viewLifecycleOwner, Observer {
                    pokemonType.setText(it)
                })
            }catch (e:Exception){
                println("erro fragment")
            }
        })











    }
}