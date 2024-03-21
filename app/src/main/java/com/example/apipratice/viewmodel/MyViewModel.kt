package com.example.apipratice.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.apipratice.models.AddCartModel
import com.example.apipratice.models.AddCartModelResponce
import com.example.apipratice.models.Product
import com.example.apipratice.repository.Repository

class MyViewModel:ViewModel() {

    var productrepository =Repository()

    fun getproducts(): LiveData<Product> {
        return productrepository.GetResponse()
    }

    fun addproductitem(cartItemRequest: ArrayList<AddCartModel>): LiveData<AddCartModelResponce> {
        return productrepository.addToCart(cartItemRequest)
    }

}