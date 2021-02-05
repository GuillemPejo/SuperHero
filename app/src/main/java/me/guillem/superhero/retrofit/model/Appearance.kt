package me.guillem.superhero.retrofit.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Appearance(
    @SerializedName("eye-color")
    @Expose
    val eye_color: String,
    @SerializedName("gender")
    @Expose
    val gender: String,
    @SerializedName("hair-color")
    @Expose
    val hair_color: String,
    @SerializedName("height")
    @Expose
    val height: List<String>,
    @SerializedName("race")
    @Expose
    val race: String,
    @SerializedName("weight")
    @Expose
    val weight: List<String>
)