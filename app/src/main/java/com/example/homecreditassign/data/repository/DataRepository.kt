package com.example.homecreditassign.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.homecreditassign.data.network.DataApi
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DataRepository {
    fun data() : LiveData<String>{
        val dataResponse = MutableLiveData<String>()
        DataApi().getData()
            .enqueue(object : Callback<ResponseBody>{
                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    dataResponse.value = t.message

                }
                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>
                ) {
                    dataResponse.value = response.body()?.string()
                }
            })
        return dataResponse
    }
}