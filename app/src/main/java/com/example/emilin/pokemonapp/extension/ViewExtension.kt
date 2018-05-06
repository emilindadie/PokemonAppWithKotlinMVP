package com.example.emilin.pokemonapp.extension

import android.view.View


fun View.showOrHideView(state : Boolean){
    if(state){
        this.visibility  = View.VISIBLE
    }else {
        this.visibility  = View.INVISIBLE
    }
}