package com.example.pokeapi.retrofit

import com.example.pokeapi.models.Pokemon
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitAPI {
    @GET("api/v2/pokemon/{name}")
    fun getPokemonWithName(@Path("name") name: String): Call<Pokemon>





    companion object{
        private val retrofitAPI: RetrofitAPI by lazy {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://pokeapi.co/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            retrofit.create(RetrofitAPI::class.java)
        }
        fun getInstanceRetrofit() : RetrofitAPI{
            return retrofitAPI
        }
    }
}