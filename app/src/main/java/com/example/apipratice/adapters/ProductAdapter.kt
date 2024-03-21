package com.example.apipratice.adapters
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apipratice.databinding.ActivityProductItemBinding
import com.example.apipratice.listner.AddclickListner
import com.example.apipratice.models.Product
import com.squareup.picasso.Picasso

class ProductAdapter(var list:Product,var clicklistner:AddclickListner):RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    inner class ViewHolder(var binding: ActivityProductItemBinding):RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view=ActivityProductItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.Products.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = list.Products[position]
        holder.binding.productRs.text = "Price-${product.price}"
        holder.binding.productTitle.text = "Title-${product.title}"
        holder.binding.productBrand.text = "Brand-${product.brand}"
        holder.binding.productCategory.text = "Category-${product.category}"
        holder.binding.productDiscount.text = "Discount%-${product.discount}"
        holder.binding.stock.text = "Stock-${product.stock}"
        holder.binding.productDiscription.text = "Description-${product.description}"
        Picasso.get().load("${product.thumbnail}").into(holder.binding.productImgId)

        holder.binding.btnAddtoCart.setOnClickListener {
            clicklistner.addcart(product)
        }

    }

}
