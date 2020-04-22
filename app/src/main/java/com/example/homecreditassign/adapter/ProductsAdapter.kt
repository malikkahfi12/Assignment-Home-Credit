package com.example.homecreditassign.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.homecreditassign.R
import com.example.homecreditassign.data.model.Item
import kotlinx.android.synthetic.main.item_products.view.*

class ProductsAdapter(
    val itemList : List<Item>,
    val context:Context)
    : RecyclerView.Adapter<ProductsAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_products, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount() = itemList.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.textProduct.text = itemList[position].productName
        Glide.with(context)
            .load(itemList[position].productImage)
            .into(holder.imageProduct)
        holder.layoutProduct.setOnClickListener(View.OnClickListener {
            context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(itemList[position].link)))
        })
    }

    class ItemViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        val imageProduct : ImageView = itemView.image_products
        val textProduct : TextView = itemView.product_name
        val layoutProduct : LinearLayout = itemView.layout_products
    }
}