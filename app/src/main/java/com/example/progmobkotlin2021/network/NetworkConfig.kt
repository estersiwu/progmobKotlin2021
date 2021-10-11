package com.example.progmobkotlin2021.network

import com.example.progmobkotlin2021.model.ResponseItem
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class NetworkConfig {
    // set interceptor
    fun getInterceptor() : OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()
        return okHttpClient
    }
    fun getRetrofit() : Retrofit {
        return Retrofit.Builder()
                //.baseUrl("https://jsonplaceholder.typicode.com/")
                .baseUrl("https://192.168.43.17/slim-ester/public")
                .client(getInterceptor())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
    fun getService() = getRetrofit().create(Users::class.java)
}
interface Users {
    @GET("users")
    fun getUsers(): Call<List<ResponseItem>>
}