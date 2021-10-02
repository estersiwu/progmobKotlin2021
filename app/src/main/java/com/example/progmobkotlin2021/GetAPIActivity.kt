package com.example.progmobkotlin2021

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.progmobkotlin2021.adapter.UsersAdapter
import com.example.progmobkotlin2021.model.ResponseItem

import com.example.progmobkotlin2021.network.NetworkConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class GetAPIActivity : AppCompatActivity() {
    lateinit var rvUser : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_apiactivity)

        rvUser = findViewById(R.id.rvUserAPI)

       NetworkConfig().getService()
           .getUsers()
           .enqueue(object : Callback<List<ResponseItem>> {
               override fun onFailure(call: Call<List<ResponseItem>>, t: Throwable) {
                   Toast.makeText(this@GetAPIActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
               }
               override fun onResponse(
                   call: Call<List<ResponseItem>>,
                   response: Response<List<ResponseItem>>
               ) {

                   rvUser.apply {
                       layoutManager = LinearLayoutManager(this@GetAPIActivity)
                       adapter = UsersAdapter(response.body())
                   }
               }
           })

    }
}