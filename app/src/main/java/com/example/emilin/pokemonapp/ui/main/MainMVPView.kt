package com.example.emilin.pokemonapp.ui.main

import com.example.emilin.pokemonapp.base.MVPView
import com.example.emilin.pokemonapp.model.Result

interface MainMVPView : MVPView{
        fun showPokemons(pokemons : List<Result>)
        fun showAnyError(error : String)
        fun showOrHideProgressBar(state : Boolean)
        fun showPokemonCount(count : Int)
        fun showPokemonName(name : String)

}