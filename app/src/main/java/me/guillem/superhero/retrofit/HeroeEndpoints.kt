package me.guillem.superhero.retrofit

import io.reactivex.Observable
import io.reactivex.Single
import me.guillem.superhero.retrofit.model.Hero
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 ** Created by Guillem on 05/02/21.
 */
interface HeroeEndpoints {

    @GET("/{id}")
    fun getHero(@Query("api_key") key: String, @Path("id") symbol: Int): Observable<Hero>

}