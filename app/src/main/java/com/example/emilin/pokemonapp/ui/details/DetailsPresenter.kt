package com.example.emilin.pokemonapp.ui.details

import com.example.emilin.pokemonapp.base.BasePresenter
import com.example.emilin.pokemonapp.base.MVPView
import com.example.emilin.pokemonapp.model.Pokemon
import com.example.emilin.pokemonapp.network.PokemonApiService
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class DetailsPresenter<V : DetailsMVPView> @Inject constructor(val pokemonApiService: PokemonApiService): BasePresenter<V>(), DetailsMVPPresenter<V>{

    override fun loadDetails(url : String) {

        getView()?.showOrHideProgressBar(true)
       var observer = object : Observer<Pokemon> {
            override fun onComplete() {
                getView()?.showOrHideProgressBar(false)
            }

            override fun onSubscribe(d: Disposable) {

            }

            override fun onNext(t: Pokemon) {
                getView()?.showDeails(t)
            }

            override fun onError(e: Throwable) {

            }

        }

        pokemonApiService.getPokemonPicture(url).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(observer)
    }

    override fun isViewIsAttached(): Boolean {
        return super.isViewAttached
    }

}