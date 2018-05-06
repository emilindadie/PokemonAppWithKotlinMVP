package com.example.emilin.pokemonapp.injection.component

import com.example.emilin.pokemonapp.injection.module.ActivityModule
import com.example.emilin.pokemonapp.injection.scope.ActivityScope
import com.example.emilin.pokemonapp.ui.details.DetailsMVPView
import com.example.emilin.pokemonapp.ui.details.DetailsPresenter
import com.example.emilin.pokemonapp.ui.details.Main2Activity
import com.example.emilin.pokemonapp.ui.main.MainActivity
import com.example.emilin.pokemonapp.ui.main.MainMVPView
import com.example.emilin.pokemonapp.ui.main.MainPresenter
import dagger.Component

@ActivityScope
@Component(dependencies = arrayOf(ApplicationComponent::class),
        modules = arrayOf(ActivityModule::class)
)
interface ActivityComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(main2Activity: Main2Activity)

    fun inject (mainPresenter: MainPresenter<MainMVPView>)
    fun inject (detailsPresenter: DetailsPresenter<DetailsMVPView>)
}