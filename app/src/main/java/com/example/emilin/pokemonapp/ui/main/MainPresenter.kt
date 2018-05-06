package com.example.emilin.pokemonapp.ui.main

import com.example.emilin.pokemonapp.base.BasePresenter
import com.example.emilin.pokemonapp.model.AllPokemonUrl
import com.example.emilin.pokemonapp.model.Pokemon
import com.example.emilin.pokemonapp.network.PokemonApiService
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class MainPresenter<V: MainMVPView> @Inject constructor(val pokemonApiService: PokemonApiService) : BasePresenter<V>() , MainMVPPresenter<V> {


    override fun loadPokemons() {

        getView()?.showOrHideProgressBar(true)
        val observerDataUrl = object : Observer<AllPokemonUrl> {
            override fun onComplete() {
            getView()?.showOrHideProgressBar(false)
            }

            override fun onSubscribe(d: Disposable) {
            }

            override fun onNext(t: AllPokemonUrl) {
                getView()?.showPokemons(t.results!!)
                onComplete()
            }

            override fun onError(e: Throwable) {

            }
        }

        /*
        pokemonApiService.getAllPokemon().observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe({
        resulut -> getView()?.showPokemons(resulut)

        })*/


        pokemonApiService.getAllPokemonUrl().observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(observerDataUrl)

        /*
        pokemonApiService.getAllPokemonUrl().observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe{ res ->

                list = res.results

            res.results?.map { pokemonApiService.getPokemonPicture(it.url).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe{ res3 ->
                pokemons.add(res3)
            }}
        }


        list?.map { res2 ->  pokemonApiService.getPokemonPicture(res2.url).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe{ res3 ->
            pokemons.add(res3)
        }}*/

        /*

        pokemonApiService.getAllPokemonUrl().observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe{ res ->
            res.results?.map { res2 ->  pokemonApiService.getPokemonPicture(res2.url).subscribeOn(Schedulers.io()).subscribe{ res3 ->
                pokemons.add(res3)
            }}
        }*/
    }

    override fun isViewIsAttached(): Boolean {
        return super.isViewAttached
    }


    override fun onAttach(view: V?) {
        super.onAttach(view)
    }

}