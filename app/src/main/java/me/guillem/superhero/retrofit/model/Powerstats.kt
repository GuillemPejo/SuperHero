package me.guillem.superhero.retrofit.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Powerstats(
    @SerializedName("combat")
    @Expose
    val combat: String,
    @SerializedName("durability")
    @Expose
    val durability: String,
    @SerializedName("intelligence")
    @Expose
    val intelligence: String,
    @SerializedName("power")
    @Expose
    val power: String,
    @SerializedName("speed")
    @Expose
    val speed: String,
    @SerializedName("strength")
    @Expose
    val strength: String
)