package com.example.apipratice.models
import com.google.gson.annotations.SerializedName

data class AddCartModelResponce(
    @SerializedName("status") val status: String,
    @SerializedName("message") val message: String
)


