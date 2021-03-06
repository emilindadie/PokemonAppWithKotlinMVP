package com.example.emilin.pokemonapp.extension

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.emilin.pokemonapp.R


fun ImageView.loadUrl(url : String){
    Glide.with(this.context).load(url)
            .placeholder(R.drawable.abc_ab_share_pack_mtrl_alpha).into(this)
}