package com.example.pokeapi.models

data class Pokemon(
    var id: Int,
    var name: String,
    var base_experience: Int,
    var sprites: Sprites,
    var types: List<PokemonType>
)

data class Sprites(
    var front_default: String
)


data class PokemonType(
    val type: Types
)

data class Types(
    var name: String,

)

