package com.example.apipratice.activity

import android.app.AlertDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import com.example.apipratice.R


import android.os.Bundle
import android.provider.Settings
import android.view.Menu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apipratice.adapters.ProductAdapter
import com.example.apipratice.databinding.ActivityMainBinding
import com.example.apipratice.listner.AddclickListner
import com.example.apipratice.models.AddCartModel
import com.example.apipratice.models.ProductModel
import com.example.apipratice.viewmodel.MyViewModel

class MainActivity : AppCompatActivity() ,AddclickListner{
    lateinit var binding:ActivityMainBinding
    lateinit var viewModel: MyViewModel
    lateinit var myAdapter:ProductAdapter
    lateinit var productid:String
    lateinit var title:String
    lateinit var stock:String
    lateinit var price:String
    lateinit var discount:String
    lateinit var brand:String
    lateinit var category:String
    lateinit var image: String
    lateinit var discription: String
    val productList = ArrayList<AddCartModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModel =ViewModelProvider(this)[MyViewModel::class.java]
        viewModel.getproducts().observe(this, Observer {

            myAdapter = ProductAdapter(it,this)
            binding.rvProductList.layoutManager = LinearLayoutManager(this)
            binding.rvProductList.adapter = myAdapter
            myAdapter.notifyDataSetChanged()

        })
        
        viewModel.addproductitem(productList).observe(this, Observer {
            Toast.makeText(this, "${it.status}", Toast.LENGTH_SHORT).show()
        })

//        checkLocationPermission()


    }
    //cart menu code
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.cartmenu,menu)
        return super.onCreateOptionsMenu(menu)
    }


//    private fun checkLocationPermission() {
//        if (ActivityCompat.checkSelfPermission(
//                this,
//                android.Manifest.permission.ACCESS_FINE_LOCATION
//            ) != PackageManager.PERMISSION_GRANTED
//        ) {
//            if (ActivityCompat.shouldShowRequestPermissionRationale(
//                    this,
//                    android.Manifest.permission.ACCESS_FINE_LOCATION
//                )
//            ) {
//                // Show rationale if needed
//                showRationaleDialog()
//            } else {
//                // No explanation needed, request the permission
//                requestLocationPermission()
//            }
//        } else {
//            // Permission already granted, proceed with checking background location
//            checkBackgroundLocation()
//        }
//    }
//
//    private fun showRationaleDialog() {
//        AlertDialog.Builder(this)
//            .setTitle("Location Permission Needed")
//            .setMessage("This app needs the Location permission, please accept to use location functionality")
//            .setPositiveButton("OK") { _, _ ->
//                // Prompt the user once explanation has been shown
//                requestLocationPermission()
//            }
//            .create()
//            .show()
//    }
//
//    private fun checkBackgroundLocation() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q &&
//            ActivityCompat.checkSelfPermission(
//                this,
//                android.Manifest.permission.ACCESS_BACKGROUND_LOCATION
//            ) != PackageManager.PERMISSION_GRANTED
//        ) {
//            // Request background location permission for Android Q and above
//            requestBackgroundLocationPermission()
//        }
//    }

//    private fun requestLocationPermission() {
//        ActivityCompat.requestPermissions(
//            this,
//            arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
//            MY_PERMISSIONS_REQUEST_LOCATION
//        )
//    }
//
//    private fun requestBackgroundLocationPermission() {
//        ActivityCompat.requestPermissions(
//            this,
//            arrayOf(android.Manifest.permission.ACCESS_BACKGROUND_LOCATION),
//            MY_PERMISSIONS_REQUEST_BACKGROUND_LOCATION
//        )
//    }
//
//    override fun onRequestPermissionsResult(
//        requestCode: Int,
//        permissions: Array<String>,
//        grantResults: IntArray
//    ) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//        when (requestCode) {
//            MY_PERMISSIONS_REQUEST_LOCATION -> {
//                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                    // Location permission granted
//                    startLocationUpdates()
//                    checkBackgroundLocation()
//                } else {
//                    // Permission denied, show rationale or redirect to settings
//                    handleDeniedPermission()
//                }
//            }
//            MY_PERMISSIONS_REQUEST_BACKGROUND_LOCATION -> {
//                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                    // Background location permission granted
//                    Toast.makeText(
//                        this,
//                        "Granted Background Location Permission",
//                        Toast.LENGTH_LONG
//                    ).show()
//                } else {
//                    // Background location permission denied
//                    Toast.makeText(this, "Background location permission denied", Toast.LENGTH_LONG).show()
//                }
//            }
//        }
//    }
//
//    private fun startLocationUpdates() {
//        if (ContextCompat.checkSelfPermission(
//                this,
//                android.Manifest.permission.ACCESS_FINE_LOCATION
//            ) == PackageManager.PERMISSION_GRANTED
//        ) {
//            // Start location updates
////            fusedLocationProvider.requestLocationUpdates(
////                locationRequest,
////                locationCallback,
////                Looper.getMainLooper()
////            )
//        }
//    }
//
//    private fun handleDeniedPermission() {
//        Toast.makeText(this, "Location permission denied", Toast.LENGTH_LONG).show()
//        if (!ActivityCompat.shouldShowRequestPermissionRationale(
//                this,
//                android.Manifest.permission.ACCESS_FINE_LOCATION
//            )
//        ) {
//            // User has denied the permission and selected "Don't ask again"
//            // Redirect to app settings
//            startActivity(
//                Intent(
//                    Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
//                    Uri.fromParts("package", packageName, null)
//                )
//            )
//        }
//    }
//

    override fun addcart(productDetail: ProductModel) {


        productid=productDetail.id.toString()
        title=productDetail.title
        stock=productDetail.stock.toString()
        price=productDetail.price.toString()
        discount=productDetail.discount.toString()
        brand=productDetail.brand
        category=productDetail.category.toString()
        image=""
        discription=""
        var temp=AddCartModel(productid,title,stock,price,discount,brand,category,image,discription)
        productList.add(temp)

        Toast.makeText(this, "item added", Toast.LENGTH_SHORT).show()
    }
}

