package com.example.progmobkotlin2021.crud

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.progmobkotlin2021.R
import com.example.progmobkotlin2021.adapter.ResponsePetaniAdapter
import com.example.progmobkotlin2021.adapter.UsersAdapter
import com.example.progmobkotlin2021.model.ResponseItem
import com.example.progmobkotlin2021.network.NetworkConfig
import com.google.android.material.floatingactionbutton.FloatingActionButton
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetPetaniActivity : AppCompatActivity() {
    lateinit var rvPetani : RecyclerView
    lateinit var fabAddPetani : FloatingActionButton

    override fun onRestart() {
        super.onRestart()

        rvPetani = findViewById(R.id.rvPetani)
        fabAddPetani = findViewById(R.id.fabAddPetani)

        NetworkConfig().getService()
                .getPetaniAll()
                .enqueue(object : Callback<List<ResponseItem>> {
                    override fun onFailure(call: Call<List<ResponseItem>>, t: Throwable) {
                        Toast.makeText(this@GetPetaniActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
                    }
                    override fun onResponse(
                            call: Call<List<ResponseItem>>,
                            response: Response<List<ResponseItem>>
                    ) {

                        rvPetani.apply {
                            layoutManager = LinearLayoutManager(this@GetPetaniActivity)
                            adapter = ResponsePetaniAdapter(response.body()?.data as List<DataItem>?)
                        }
                    }
                })

    }
}