package com.example.emilin.pokemonapp.ui.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import com.example.emilin.pokemonapp.R
import com.example.emilin.pokemonapp.adapter.PokemonAdapter
import com.example.emilin.pokemonapp.base.BaseActivity
import com.example.emilin.pokemonapp.extension.showOrHideView
import com.example.emilin.pokemonapp.model.Result
import com.example.emilin.pokemonapp.ui.details.Main2Activity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.search_card.*
import kotlinx.android.synthetic.main.toolbar.*
import javax.inject.Inject

class MainActivity : BaseActivity(), MainMVPView {
    override fun showPokemonName(name: String) {
        Toast.makeText(this, name, Toast.LENGTH_LONG).show()
    }

    override fun showPokemonCount(count: Int) {
        Toast.makeText(this, count.toString(), Toast.LENGTH_LONG).show()
    }

    lateinit var pokemonAdapter : PokemonAdapter
    @Inject lateinit var presenter: MainMVPPresenter<MainMVPView>


    override fun showPokemons(pokemon: List<Result>) {
        pokemonAdapter.loadPokemons(pokemon).let {
            Toast.makeText(this,"taille "+ pokemonAdapter.pokemons.size.toString(), Toast.LENGTH_LONG).show()
        }

    //pokemonAdapter.loadPokemons(pokemons)
       // Toast.makeText(this, pokemons.size.toString(), Toast.LENGTH_LONG).show()
    }

    override fun showAnyError(error: String) {

    }

        override fun showOrHideProgressBar(state: Boolean) {
        mainResultsSpinner.showOrHideView(state)
        }

    override fun getLayoutResId(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        super.component.inject(this)
        setSupportActionBar(toolbar)
        setUpRecyclerView()

        /*
        with(presenter){
            onAttach(this.getView())
            loadPokemons()
        }*/


        presenter.onAttach(this)
        presenter.loadPokemons()


        searchCardEditText.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                pokemonAdapter.filterByPokemonName(s.toString())
            }
        })
    }

    fun setUpRecyclerView() {

        mainResultsRecycler.layoutManager = LinearLayoutManager(this)
        mainResultsRecycler.setHasFixedSize(true)

        pokemonAdapter = PokemonAdapter(object : PokemonAdapter.OnItemClick {
            override fun click(pokemon: Result, position: Int) {

                val intent = newIntent(this@MainActivity, pokemon)
                startActivity(intent)
            }
        })

        mainResultsRecycler.adapter = pokemonAdapter
    }

    fun newIntent(context: Context, pokemon: Result): Intent {
        val intent = Intent(context, Main2Activity::class.java)
        intent.putExtra("url", pokemon.url)
        return intent
    }
}
