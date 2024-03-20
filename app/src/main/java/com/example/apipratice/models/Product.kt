package com.example.apipratice.models

import com.google.gson.annotations.SerializedName

data class Product(
    @SerializedName("products")
    var Products:ArrayList<ProductModel>
)
