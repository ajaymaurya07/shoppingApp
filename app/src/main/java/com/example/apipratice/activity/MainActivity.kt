package com.example.apipratice.activity

import com.example.apipratice.R


import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apipratice.adapters.ProductAdapter
import com.example.apipratice.databinding.ActivityMainBinding
import com.example.apipratice.viewmodel.MyViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    lateinit var viewModel: MyViewModel
    lateinit var myAdapter:ProductAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModel =ViewModelProvider(this)[MyViewModel::class.java]
        viewModel.getproducts().observe(this, Observer {

            myAdapter = ProductAdapter(it)
            binding.rvProductList.layoutManager = LinearLayoutManager(this)
            binding.rvProductList.adapter = myAdapter
            myAdapter.notifyDataSetChanged()

        })


    }
    //cart menu code
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.cartmenu,menu)
        return super.onCreateOptionsMenu(menu)
    }

}