package me.guillem.superhero.retrofit

import io.reactivex.Single
import me.guillem.superhero.retrofit.model.Hero
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 ** Created by Guillem on 04/02/21.
 */
interface APIInterface {

    @GET("/{id}")
    fun getHero(@Path("id") symbol: String?): Single<Hero?>?

}