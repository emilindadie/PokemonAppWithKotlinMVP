package com.example.emilin.pokemonapp.base

abstract class BasePresenter<V : MVPView> : MVPPresenter<V>{

    private var view: V? = null
    protected val isViewAttached: Boolean get() = view != null
    override fun onAttach(view: V?) {
        this.view = view
    }

    override fun onDetach() {
        this.view = null
    }

    override fun getView(): V? = view
}