package com.example.emilin.pokemonapp.ui.details

import com.example.emilin.pokemonapp.base.MVPView
import com.example.emilin.pokemonapp.model.Pokemon

interface DetailsMVPView : MVPView{
    fun showDeails(pokemon : Pokemon)
    fun showOrHideProgressBar(state : Boolean)
}