package com.example.emilin.pokemonapp.base

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.emilin.pokemonapp.R
import com.example.emilin.pokemonapp.app.MainApp
import com.example.emilin.pokemonapp.databinding.ActivityMain2Binding
import com.example.emilin.pokemonapp.injection.component.ActivityComponent
import com.example.emilin.pokemonapp.injection.component.DaggerActivityComponent
import com.example.emilin.pokemonapp.injection.module.ActivityModule

abstract class BaseActivity : AppCompatActivity(), MVPView {
    lateinit var component: ActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       // val binding: ActivityMain2Binding = DataBindingUtil.setContentView(this, R.layout.activity_main2)

        setContentView(getLayoutResId())
        initInjector()

    }

    override fun showProgress() {

    }

    override fun hideProgress() {

    }

    abstract fun getLayoutResId() : Int

    private fun initInjector() {
        component = DaggerActivityComponent.builder()
                .applicationComponent(MainApp.component)
                .activityModule(ActivityModule(this))
                .build()
    }
}