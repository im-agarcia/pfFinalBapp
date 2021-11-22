package com.example.proyectofinalkotlin.entities

import com.example.proyectofinalkotlin.classes.UserDataCollectionItem
import retrofit2.Call
import retrofit2.http.GET

interface UserService {
    @GET("users")
    fun listUsers() : Call<List<UserDataCollectionItem>>
}