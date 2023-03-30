package com.example.pokeapi.repository

import com.example.pokeapi.models.Pokemon
import com.example.pokeapi.retrofit.RetrofitAPI
import retrofit2.Call

class MainRepository constructor(private val retrofitAPI: RetrofitAPI){

    //fun getPokemonRepo() = retrofitAPI.getPokemonWithName2()



    fun getPokemonRepository(namePokemon: String) : Call<Pokemon>{
        val nameOfPokemon = retrofitAPI.getPokemonWithName(namePokemon)
        return nameOfPokemon
    }
}