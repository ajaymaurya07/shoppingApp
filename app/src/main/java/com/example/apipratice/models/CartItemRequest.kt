package com.example.apipratice.models

data class CartItemRequest(
    val userId: Int,
    val products: List<AddCartModel>
)
