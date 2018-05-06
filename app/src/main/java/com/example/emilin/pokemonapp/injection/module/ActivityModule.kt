package com.example.emilin.pokemonapp.injection.module

import android.app.Activity
import android.content.Context
import com.example.emilin.pokemonapp.injection.scope.ActivityContext
import com.example.emilin.pokemonapp.injection.scope.ActivityScope
import com.example.emilin.pokemonapp.network.PokemonApiService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import com.example.emilin.pokemonapp.BuildConfig
import com.example.emilin.pokemonapp.ui.details.DetailsMVPPresenter
import com.example.emilin.pokemonapp.ui.details.DetailsMVPView
import com.example.emilin.pokemonapp.ui.details.DetailsPresenter
import com.example.emilin.pokemonapp.ui.main.MainMVPPresenter
import com.example.emilin.pokemonapp.ui.main.MainMVPView
import com.example.emilin.pokemonapp.ui.main.MainPresenter

@Module
class ActivityModule (val activity: Activity) {
    @Provides
    internal fun provideActivity(): Activity = activity

    @Provides
    @ActivityContext
    internal fun provideActivityContext(): Context = activity


    @Provides
    @ActivityScope
    fun provideGitHubApiService(): PokemonApiService {
        val interceptor = HttpLoggingInterceptor();
        interceptor.setLevel(if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE);
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()


        return Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://pokeapi.co/")
                .client(client)
                .build()
                .create(PokemonApiService::class.java)
        /*
        return retrofit2.Retrofit.Builder()
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://pokeapi.co/")
                .build()
                .create(GithubApiService::class.java)*/
    }

    @Provides
    @ActivityScope
    fun provideMainPresenter(mainPresenter: MainPresenter<MainMVPView>) : MainMVPPresenter<MainMVPView> = mainPresenter

    @Provides
    @ActivityScope
    fun provideDetailsPresenter(detailsPresenter: DetailsPresenter<DetailsMVPView>) : DetailsMVPPresenter<DetailsMVPView> = detailsPresenter
}