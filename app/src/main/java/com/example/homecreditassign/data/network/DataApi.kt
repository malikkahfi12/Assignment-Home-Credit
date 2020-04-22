package com.example.homecreditassign.data.network

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface DataApi{
    @GET("home")
    fun getData() : Call<ResponseBody>

    companion object{
        operator fun invoke() : DataApi{
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://private-a8e48-hcidtest.apiary-mock.com/")
                .build()
                .create(DataApi::class.java)
        }
    }
}