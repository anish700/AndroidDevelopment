package com.example.webapp1
import com.google.gson.JsonElement
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Query
import java.util.*

interface ApiService {

    @GET("/api/unknown")
    fun getWeatherData():Call<JsonElement>



}
fun function(){

}