package com.example.emilin.pokemonapp.adapter

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.emilin.pokemonapp.R
import com.example.emilin.pokemonapp.model.Pokemon
import com.example.emilin.pokemonapp.model.Result
import java.util.ArrayList


class PokemonAdapter(val onItemClick: OnItemClick) : RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

    var pokemons : List<Result> = ArrayList()

    var subPokemon : List<Result> = ArrayList()

    companion object {
        var mClickListener: OnItemClick? = null
    }
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.pokemon, parent, false)
        return ViewHolder(v);
    }

    override fun onBindViewHolder(holder: ViewHolder?, @SuppressLint("RecyclerView") position: Int) {
        mClickListener = onItemClick
        val currentUser = subPokemon[position]
        holder?.name?.text = currentUser.name

        /*
        holder?.itemView?.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                onItemClick.click(pokemons[position], holder.adapterPosition)
            }
        })*/

        holder?.itemView?.setOnClickListener{
            onItemClick.click(subPokemon[position], holder.adapterPosition)
        }
    }

    fun loadPokemons(pokemons : List<Result>){
        this.pokemons = pokemons
        this.subPokemon = pokemons
        notifyDataSetChanged()
    }


    override fun getItemCount(): Int {
        return subPokemon.size
    }

    class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        val name = itemView?.findViewById<TextView>(R.id.pokemon)
    }

    interface OnItemClick {
        fun click(pokemon: Result, position: Int)
    }

    fun filterByPokemonName(name : String){

        if(name.length == 0){
            this.subPokemon = pokemons;
        }else{
            this.subPokemon =  pokemons.filter{ it -> it.name.startsWith(name) }
        }

        notifyDataSetChanged()
    }
}