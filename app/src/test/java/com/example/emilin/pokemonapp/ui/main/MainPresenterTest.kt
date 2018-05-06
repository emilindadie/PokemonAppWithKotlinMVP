package com.example.emilin.pokemonapp.ui.main

import com.example.emilin.pokemonapp.model.Pokemon
import com.example.emilin.pokemonapp.network.PokemonApiService
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class MainPresenterTest {

    @Mock
    lateinit var mainMVPPresenter: MainMVPPresenter<MainMVPView>

    @Mock
    lateinit var pokemonApiService: PokemonApiService

    @Mock
    lateinit var mainView: MainMVPView

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        mainMVPPresenter = MainPresenter<MainMVPView>(pokemonApiService)
        mainMVPPresenter .onAttach(mainView)
    }

    @Test
    fun loadPokemons() {
    }

    @Test
    fun isViewIsAttached() {
    }

    @Test
    fun onAttach() {
    }

    @Test
    fun getPokemonApiService() {
    }
}