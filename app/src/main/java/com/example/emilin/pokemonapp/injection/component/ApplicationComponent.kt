package com.example.emilin.pokemonapp.injection.component

import com.example.emilin.pokemonapp.app.MainApp
import com.example.emilin.pokemonapp.injection.module.ApplicationModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {
    fun inject(app: MainApp)
}