package me.guillem.superhero.retrofit

import io.reactivex.Observable
import io.reactivex.Single
import me.guillem.superhero.retrofit.model.ProfileModel
import me.guillem.superhero.retrofit.model.SuperHeroModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 ** Created by Guillem on 05/02/21.
 */
interface HeroeEndpoints {

    //@GET("{id}")
    //fun gestHero( @Path("id") symbol: Int, @Query("api_key") key: String): Observable<Hero>

    @GET("{id}")
    fun getHero(@Path("id") id: String): Observable<ProfileModel>

}