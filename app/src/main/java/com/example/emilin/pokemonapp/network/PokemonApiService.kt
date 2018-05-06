package com.example.emilin.pokemonapp.network

import com.example.emilin.pokemonapp.model.AllPokemonUrl
import com.example.emilin.pokemonapp.model.Pokemon
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url

interface PokemonApiService {

    @GET("api/v2/pokemon/?limit=400&offset=0")
    fun getAllPokemonUrl() : Observable<AllPokemonUrl>

    @GET
    fun getPokemonPicture(@Url url: String) : Observable<Pokemon>
}