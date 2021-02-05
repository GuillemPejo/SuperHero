package me.guillem.superhero.retrofit.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SuperHeroModel(

    @SerializedName("response")
    @Expose
    val response: String,
    @SerializedName("results")
    @Expose
    val results: List<ResultModel>,
    @SerializedName("results-for")
    @Expose
    val results_for: String
)