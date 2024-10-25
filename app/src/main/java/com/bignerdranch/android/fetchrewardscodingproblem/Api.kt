package com.bignerdranch.android.fetchrewardscodingproblem

import retrofit2.Call
import retrofit2.http.GET

//Refrofit interface for defining API endpoints
interface Api {
    @GET("hiring.json")
    fun getItem(): Call<List<Items>>
}