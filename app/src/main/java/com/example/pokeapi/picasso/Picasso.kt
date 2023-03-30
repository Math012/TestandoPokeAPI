package com.example.pokeapi.picasso

import android.widget.ImageView

class Picasso {
    fun converImage(imgURL: String, image: ImageView){
        com.squareup.picasso.Picasso.get()
            .load(imgURL)
            .resize(300,300)
            .placeholder(com.example.pokeapi.R.drawable.ic_launcher_foreground)
            .into(image)
    }
}