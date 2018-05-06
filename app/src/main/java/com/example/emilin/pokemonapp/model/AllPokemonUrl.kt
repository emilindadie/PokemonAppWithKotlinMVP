package com.example.emilin.pokemonapp.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class AllPokemonUrl (
        @field:SerializedName("count")
        val count: Int? = null,
        @field:SerializedName("previous")
        val previous: String? = null,
        @field:SerializedName("results")
        val results: List<Result>? = null,
        @field:SerializedName("next")
        val next: String? = null
)