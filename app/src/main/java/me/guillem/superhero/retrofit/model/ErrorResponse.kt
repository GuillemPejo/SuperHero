package me.guillem.superhero.retrofit.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 ** Created by Guillem on 05/02/21.
 */
data class ErrorResponse(

    @SerializedName("error")
    @Expose
    val error: String,
    @SerializedName("response")
    @Expose
    val response: String
)