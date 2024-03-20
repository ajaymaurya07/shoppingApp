package com.example.apipratice.methods

import com.example.apipratice.models.Product
import retrofit2.Call
import retrofit2.http.GET

interface ApiMethods {

    @GET("/products")
     fun getproduct() : Call<Product>

}