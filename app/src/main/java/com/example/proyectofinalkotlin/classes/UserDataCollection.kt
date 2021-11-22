package com.example.proyectofinalkotlin.classes

class UserDataCollection : ArrayList<UserDataCollectionItem>()

data class UserDataCollectionItem(
    val `data`: Data,
    val user: String
)

data class Data(
    val bio: String,
    val city: String,
    val email: String,
    val expanded: Boolean,
    val firstname: String,
    val friends: List<Any>,
    val genres: List<Any>,
    val id: String,
    val instruments: List<Instrument>,
    val password: String
)

data class Instrument(
    val active: Boolean,
    val id: String,
    val name: String
)