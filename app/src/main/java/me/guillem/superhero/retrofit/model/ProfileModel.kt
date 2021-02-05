package me.guillem.superhero.retrofit.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 ** Created by Guillem on 05/02/21.
 */

data class ProfileModel(

    @SerializedName("appearance")
    @Expose
    val appearance: Appearance,
    @SerializedName("biography")
    @Expose
    val biography: Biography,
    @SerializedName("connections")
    @Expose
    val connections: Connections,
    @SerializedName("id")
    @Expose
    val id: String,
    @SerializedName("image")
    @Expose
    val image: Image,
    @SerializedName("name")
    @Expose
    val name: String,
    @SerializedName("powerstats")
    @Expose
    val powerstats: Powerstats,
    @SerializedName("response")
    @Expose
    val response: String,
    @SerializedName("work")
    @Expose
    val work: Work
)