package com.example.progmobkotlin2021.network

import com.example.progmobkotlin2021.model.DataItem
import com.example.progmobkotlin2021.model.ResponseAddPetani
import com.example.progmobkotlin2021.model.ResponseItem
import com.example.progmobkotlin2021.model.ResponsePetani
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

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
                .baseUrl("https://192.168.43.17/slim-toko_buah/public/")
                .client(getInterceptor())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
    fun getService() = getRetrofit().create(Users::class.java)
}
interface Users {
    @GET("users")
    fun getUsers(): Call<List<ResponseItem>>

    @GET("petani/")
    fun getPetaniAll(): Call<ResponsePetani>

    @POST("petani/")
    fun addPetani(@Body req : DataItem): Call<ResponseAddPetani>

    @PUT("petani/{id}")
    fun updatePetani(@Path("id") id: Int, @Body req : DataItem): Call<ResponseAddPetani>

    @DELETE("petani/{id}")
    fun deletePetani(@Path("id") id: Int): Call<ResponseAddPetani>

}