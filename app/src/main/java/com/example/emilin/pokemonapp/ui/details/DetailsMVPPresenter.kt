package com.example.emilin.pokemonapp.ui.details

import com.example.emilin.pokemonapp.base.MVPPresenter

interface DetailsMVPPresenter <V : DetailsMVPView> : MVPPresenter<V> {
    fun loadDetails(url : String)
    fun isViewIsAttached() : Boolean
}