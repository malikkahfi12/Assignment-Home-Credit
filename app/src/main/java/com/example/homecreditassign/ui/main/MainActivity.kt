package com.example.homecreditassign.ui.main

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homecreditassign.R
import com.example.homecreditassign.adapter.ArticlesAdapter
import com.example.homecreditassign.adapter.ProductsAdapter
import com.example.homecreditassign.data.model.Data
import com.example.homecreditassign.data.model.Item
import com.example.homecreditassign.data.repository.DataRepository
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){
    val itemListProduct = ArrayList<Item>()
    val itemListArticles = ArrayList<Item>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val response = DataRepository().data()

        setState(true)
        response.observe(this, Observer {

            setState(false)
            val gson = GsonBuilder().setPrettyPrinting().create()
            val response = gson.fromJson(it, Data::class.java)

            text_articles.text = response.data[0].sectionTitle

            getDataProducts(response)
            getDataArticles(response)
        })
    }

    private fun getDataArticles(response: Data?) {
        for (index in response!!.data[0].itemProducts.indices){
            val articleName:String = response.data[0].itemProducts[index].articleTitle
            val articleImage:String = response.data[0].itemProducts[index].articleImage
            val link:String = response.data[0].itemProducts[index].link
            val dataItemArticles = Item(link,"","", articleImage, articleName)
            itemListArticles += dataItemArticles
        }
        val articlesAdapter = ArticlesAdapter(itemListArticles, this)
        recycler_view_article.layoutManager = LinearLayoutManager(this)
        recycler_view_article.adapter = articlesAdapter
    }

    private fun getDataProducts(response: Data?) {
        for (index in response!!.data[1].itemProducts.indices){
            val productName:String = response.data[1].itemProducts[index].productName
            val productImage:String = response.data[1].itemProducts[index].productImage
            val link:String = response.data[1].itemProducts[index].link
            val dataItemProduct = Item(link,productImage,productName, "","")
            itemListProduct += dataItemProduct
            Log.d("index", index.toString())
        }
        val productAdapter = ProductsAdapter(itemListProduct, this)
        recycler_view_product.layoutManager = GridLayoutManager(this@MainActivity, 3)
        recycler_view_product.adapter = productAdapter
    }


    fun setState(state:Boolean):Boolean{
        if (state){
            progress_bar.visibility = View.VISIBLE
            layout_data.visibility = View.GONE
        } else{
            progress_bar.visibility = View.GONE
            layout_data.visibility = View.VISIBLE
        }
        return state
    }


}
