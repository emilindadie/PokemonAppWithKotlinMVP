package com.example.emilin.pokemonapp.model

import com.google.gson.annotations.SerializedName

data class Pokemon (
        @field:SerializedName("name")
         val name: String,
        @field:SerializedName("sprites")
        val sprites: Sprites)