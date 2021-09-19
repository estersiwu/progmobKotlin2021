package com.example.progmobkotlin2021

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.progmobkotlin2021.adapter.PetaniAdapter
import com.example.progmobkotlin2021.adapter.PetaniCVAdapter
import com.example.progmobkotlin2021.model.Petani

class SampleCardView : AppCompatActivity() {

    lateinit var rvCardView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample_card_view)

        rvCardView = findViewById(R.id.rvCardView)

        val listPetani = listOf(
                Petani("ES", "Ester Siwu", "100", "50", "50"),
                Petani("ES2", "Ester Siwu", "100", "50", "50"),
                Petani("ES3", "Ester Siwu", "100", "50", "50"),
                Petani("ES4", "Ester Siwu", "100", "50", "50"),
                Petani("ES5", "Ester Siwu", "100", "50", "50")
        )

        val petaniCVAdapter = PetaniCVAdapter(listPetani)

        rvCardView.apply {
            layoutManager = LinearLayoutManager(this@SampleCardView)
            adapter = petaniCVAdapter
        }
    }
}