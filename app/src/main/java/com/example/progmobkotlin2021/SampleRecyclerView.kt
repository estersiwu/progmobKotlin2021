package com.example.progmobkotlin2021

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.progmobkotlin2021.adapter.PetaniAdapter
import com.example.progmobkotlin2021.model.Petani

class SampleRecyclerView : AppCompatActivity() {

    lateinit var rvLatihan : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample_recycler_view)

        rvLatihan = findViewById(R.id.rvLatihan)
        val listPetani = listOf(
                Petani("ES", "Ester Siwu", "100", "50", "50"),
                Petani("ES2", "Ester Siwu", "100", "50", "50"),
                Petani("ES3", "Ester Siwu", "100", "50", "50"),
                Petani("ES4", "Ester Siwu", "100", "50", "50"),
                Petani("ES5", "Ester Siwu", "100", "50", "50")
        )

        val petaniAdapter = PetaniAdapter(listPetani)

        rvLatihan.apply {
            layoutManager = LinearLayoutManager(this@SampleRecyclerView)
            adapter = petaniAdapter
        }
    }
}