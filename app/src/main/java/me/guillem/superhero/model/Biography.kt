package me.guillem.superhero.model

data class Biography(
    val aliases: List<String>,
    val alignment: String,
    val alter_egos: String,
    val first_appearance: String,
    val full_name: String,
    val place_of_birth: String,
    val publisher: String
)