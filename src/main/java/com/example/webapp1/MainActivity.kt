package com.example.webapp1

//http://dummy.restapiexample.com/api/v1/employees

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.gson.JsonElement
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
//import sun.util.logging.LoggingSupport.setLevel



class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"
//    companion object {
//
//        fun createApiService(): ApiService {
//
//
//           val interceptor = HttpLoggingInterceptor()
//            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
//            val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
//
//            val retrofit = Retrofit.Builder()
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .addConverterFactory(GsonConverterFactory.create())
//                .baseUrl("https://reqres.in")
//                .client(client)
//                .build()
//
//            return retrofit.create(ApiService::class.java)
//        }
//    }

    /*private val weatherApiServe by lazy {
        ApiService.create()
    }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_search.setOnClickListener {
            val intent =    Intent(this,RecyclerViewActivity :: class.java)
            startActivity(intent)


        }
    }



    override fun onPause() {
        super.onPause()

    }
}

class Model{
    companion object{

        data class CustomModel(
            var id: String? = null,
            var name:String? = null
        )
    }
}
