package com.example.apipratice.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.apipratice.models.Product
import com.example.apipratice.network.Retrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {
    val liveResponse: MutableLiveData<Product> = MutableLiveData<Product>()
    fun GetResponse(): MutableLiveData<Product> {

        val call= Retrofit.apiCall.getproduct()
        call.enqueue(object : Callback<Product> {
            override fun onResponse(call: Call<Product>, response: Response<Product>) {
                if(response.isSuccessful){
                    liveResponse.value=response.body()
                    Log.d("TAG", "onResponse: ${response.body()}")
                }
            }
            override fun onFailure(call: Call<Product>, t: Throwable) {

            }

        })

        return liveResponse
    }

}


