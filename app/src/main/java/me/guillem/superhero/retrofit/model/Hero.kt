package me.guillem.superhero.retrofit.model

data class Hero(
    val results: List<Result>
)

data class Result(
    val appearance: Appearance,
    val biography: Biography,
    val connections: Connections,
    val id: String,
    val image: Image,
    val name: String,
    val powerstats: Powerstats,
    val response: String,
    val work: Work
)