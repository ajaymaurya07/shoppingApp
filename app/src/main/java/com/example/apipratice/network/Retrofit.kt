package com.example.apipratice.network


import com.example.apipratice.methods.ApiMethods
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object Retrofit {
    private val retrofitClient: Retrofit.Builder by lazy {
        Retrofit.Builder()
            .baseUrl("https://dummyjson.com")
            .addConverterFactory(GsonConverterFactory.create())
    }

    val apiCall: ApiMethods by lazy {
        retrofitClient.build().create(ApiMethods::class.java)
    }
}