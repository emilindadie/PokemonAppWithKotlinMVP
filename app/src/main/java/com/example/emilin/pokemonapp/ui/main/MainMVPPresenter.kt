package com.example.emilin.pokemonapp.ui.main

import com.example.emilin.pokemonapp.base.MVPPresenter

interface MainMVPPresenter<V : MainMVPView> : MVPPresenter<V> {
    fun loadPokemons()
    fun isViewIsAttached() : Boolean
}