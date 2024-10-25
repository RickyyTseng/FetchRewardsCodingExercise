package com.bignerdranch.android.fetchrewardscodingproblem

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Setting up a singleton stance of retrofit
object RetrofitInstance {
    private const val BASE_URL = ("https://fetch-hiring.s3.amazonaws.com/")
    fun getInstance(): Retrofit{
        return Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
    }
}