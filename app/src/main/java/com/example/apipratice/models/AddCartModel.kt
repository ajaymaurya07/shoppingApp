package com.example.apipratice.models

import java.io.Serializable

data class AddCartModel(
    val productid:String,
    val title:String,
    val stock:String,
    val price:String,
    val discount:String,
    val brand:String,
    val category:String,
    val image: String,
    val discription: String,

    ) : Serializable