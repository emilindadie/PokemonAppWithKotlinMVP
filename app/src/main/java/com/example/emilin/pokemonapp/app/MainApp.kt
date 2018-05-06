package com.example.emilin.pokemonapp.app

import android.app.Application
import com.example.emilin.pokemonapp.injection.component.ApplicationComponent
import com.example.emilin.pokemonapp.injection.component.DaggerApplicationComponent
import com.example.emilin.pokemonapp.injection.module.ApplicationModule

class MainApp : Application() {

    companion object {
        lateinit var component: ApplicationComponent
    }
    override fun onCreate() {
        super.onCreate()

        component = DaggerApplicationComponent.builder().applicationModule(ApplicationModule(this)).build()
        component.inject(this)
    }
}