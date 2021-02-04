package me.guillem.superhero.model

data class Appearance(
    val eye_color: String,
    val gender: String,
    val hair_color: String,
    val height: List<String>,
    val race: String,
    val weight: List<String>
)