package com.example.emilin.pokemonapp.ui.details

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import com.example.emilin.pokemonapp.R
import com.example.emilin.pokemonapp.base.BaseActivity
import com.example.emilin.pokemonapp.databinding.ActivityMain2Binding
import com.example.emilin.pokemonapp.extension.loadUrl
import com.example.emilin.pokemonapp.extension.showOrHideView
import com.example.emilin.pokemonapp.model.Pokemon
import kotlinx.android.synthetic.main.activity_main2.*

import javax.inject.Inject

class Main2Activity : BaseActivity(), DetailsMVPView{
    override fun showOrHideProgressBar(state: Boolean) {
        progressBar.showOrHideView(state)
    }

    @Inject
    lateinit var presenter: DetailsMVPPresenter<DetailsMVPView>

   override fun getLayoutResId(): Int {
        return R.layout.activity_main2
    }
    override fun showDeails(pokemon: Pokemon) {
        val binding: ActivityMain2Binding = DataBindingUtil.setContentView(this, R.layout.activity_main2)
        if(true) binding.data = pokemon

        with(pokemon){
            pokemonPicture.loadUrl(sprites.front_default)
            pokemonName.text = name
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        super.component.inject(this)
        presenter.onAttach(this)

        var intent : Intent = intent
        with(intent){
            getStringExtra("url").let {
                presenter.loadDetails(it)
            }
        }
    }
}
