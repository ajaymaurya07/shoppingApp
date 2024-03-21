package com.example.apipratice.methods


import com.example.apipratice.models.AddCartModelResponce
import com.example.apipratice.models.CartItemRequest
import com.example.apipratice.models.Product
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiMethods {

    @GET("/products")
     fun getproduct() : Call<Product>

     @POST("/cart/add")
     fun getCartresponse(@Body cartitem:CartItemRequest):Call<AddCartModelResponce>

}

