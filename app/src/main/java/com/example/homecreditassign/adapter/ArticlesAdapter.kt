package com.example.homecreditassign.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.homecreditassign.R
import com.example.homecreditassign.data.model.Item
import kotlinx.android.synthetic.main.item_articles.view.*

class ArticlesAdapter(
    val itemArticles: List<Item>,
    val context:Context
):RecyclerView.Adapter<ArticlesAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_articles, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount() = itemArticles.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.textDescArticles.text =  itemArticles[position].articleTitle
        Glide.with(context)
            .load(itemArticles[position].articleImage)
            .into(holder.imageArticles)
        holder.layoutActicles.setOnClickListener(View.OnClickListener {
            context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(itemArticles[position].link)))
        })

    }

    class ItemViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val imageArticles : ImageView = itemView.image_article
        val textDescArticles : TextView = itemView.text_desc_article
        val layoutActicles : CardView = itemView.layout_articles
    }
}