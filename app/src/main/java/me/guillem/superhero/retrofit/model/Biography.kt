package me.guillem.superhero.retrofit.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Biography(
    @SerializedName("aliases")
    @Expose
    val aliases: List<String>,
    @SerializedName("alignment")
    @Expose
    val alignment: String,
    @SerializedName("alter-egos")
    @Expose
    val alter_egos: String,
    @SerializedName("first-appearance")
    @Expose
    val first_appearance: String,
    @SerializedName("full-name")
    @Expose
    val full_name: String,
    @SerializedName("place-of-birth")
    @Expose
    val place_of_birth: String,
    @SerializedName("publisher")
    @Expose
    val publisher: String
)