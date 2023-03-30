package com.example.pokeapi.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokeapi.models.Pokemon
import com.example.pokeapi.repository.MainRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel constructor(private val repository: MainRepository) : ViewModel(){
    val pokemon = MutableLiveData<Pokemon>()
    val typePoke = MutableLiveData<String>()



    fun getPokemonMainViewModel(name: String) : MutableLiveData<Pokemon>{
        repository.getPokemonRepository(name.lowercase().replace(" ", "")).enqueue(object : Callback<Pokemon>{
            override fun onResponse(call: Call<Pokemon>, response: Response<Pokemon>) {
                val pokemonResponse = response.body()
                val pokemonType = response.body()?.types
                var type = ""
                pokemon.postValue(pokemonResponse)
                try {
                    for (items in pokemonType!!.iterator()){

                        type = items.type.name
                    }
                    typePoke.postValue(type)
                }catch (e:Exception){
                    println("error type")
                }


            }

            override fun onFailure(call: Call<Pokemon>, t: Throwable) {
                println("Deu erro")
            }
        })
        return pokemon
    }
/*


    fun getPokeViewModel(){
        val response = repository.getPokemonRepo()
        response.enqueue(object : Callback<Pokemon>{
            override fun onResponse(call: Call<Pokemon>, response: Response<Pokemon>) {
                val items = response.body()
                var items2 = response.body()?.types
                var name = ""
                for (item in items2!!.iterator()){
                    name = item.type.name
                }
                typePoke.postValue(name)
                println(items)
            }

            override fun onFailure(call: Call<Pokemon>, t: Throwable) {
                println("DEU RUIM NO FIXO")
            }

        })
    } */
}