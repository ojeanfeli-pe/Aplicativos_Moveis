package com.example.exemplo1

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("posts?userId=${2}")
    fun getPosts(): Call<List<Post>>
}