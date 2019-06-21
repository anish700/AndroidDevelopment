package com.example.webapp1

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.google.gson.JsonElement
import kotlinx.android.synthetic.main.activity_main.*

import kotlinx.android.synthetic.main.recyclerview_layout.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RecyclerViewActivity : AppCompatActivity() {
    companion object {

        fun createApiService(): ApiService {


            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://reqres.in")
                .client(client)
                .build()

            return retrofit.create(ApiService::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recyclerview_layout)

        recyclerView_main.layoutManager = LinearLayoutManager(this)

        val mainAdapter = MainAdapter()


        val apiService = RecyclerViewActivity.createApiService()
        val weatherCall = apiService.getWeatherData()
        weatherCall.enqueue(object : Callback<JsonElement> {

            override fun onFailure(call: Call<JsonElement>, t: Throwable) {
                edit_search.setText("Error")
            }

            override fun onResponse(call: Call<JsonElement>, response: Response<JsonElement>) {
                val obj = response.body()?.asJsonObject
                val jsonArr = obj?.get("data")?.asJsonArray
                val arraylist = ArrayList<Model.Companion.CustomModel>()

                jsonArr?.forEachIndexed { index, jsonElement ->
                    val o = jsonElement.asJsonObject
                    val customModel = Model.Companion.CustomModel()

                    customModel.id = o.get("id")?.asString
                    println(" VVVVVVVVVVVV   " + o.get("name")?.asString)
                    customModel.name = o.get("name")?.asString
                    arraylist.add(customModel)

                    if(index==20) return@forEachIndexed
                }
                mainAdapter.setter(arraylist)
                recyclerView_main.adapter = mainAdapter

            }

        })

        //textView2.text = "CLICKED ITEM : "+intent


    }
}
