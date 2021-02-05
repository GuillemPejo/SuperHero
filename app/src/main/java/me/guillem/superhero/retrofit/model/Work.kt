package me.guillem.superhero.retrofit.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Work(
    @SerializedName("base")
    @Expose
    val base: String,
    @SerializedName("occupation")
    @Expose
    val occupation: String
)