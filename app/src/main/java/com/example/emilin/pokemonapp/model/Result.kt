package com.example.emilin.pokemonapp.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Result (
        @field:SerializedName("url")
        val url:  String,
        @field:SerializedName("name")
        val name : String
)