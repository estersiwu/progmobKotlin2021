package com.example.progmobkotlin2021.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.progmobkotlin2021.R
import com.example.progmobkotlin2021.model.Petani

class ResponsePetaniAdapter(var petani: List<DataItem>?): RecyclerView.Adapter<ResponsePetaniAdapter.PetaniHolder>() {
    lateinit var mContext: Context
    lateinit var adapter: ResponsePetaniAdapter

    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
    ): ResponsePetaniAdapter.PetaniHolder {
        return PetaniHolder(LayoutInflater.from(parent.context).inflate(R.layout.rv_item_petani, parent, false))
    }

    override fun onBindViewHolder(holder: ResponsePetaniAdapter.PetaniHolder, position: Int) {
        holder.bindPetani(petani?.get(position))
        var popupMenu = PopupMenu(holder.itemView.context, holder.itemView)
        popupMenu.menu.add(Menu.NONE,0,0,"Edit")
        popupMenu.menu.add(Menu.NONE,1,1,"Delete")
        popupMenu.setOnMenuItemClickListener { menuItem ->
            val id = menuItem.itemId
            mContext = holder.itemView.context
            if (id==0){
                var bundle()
                var idTmp = petani?.get(position)?.id.toString()
            }
        }
    }

    override fun getItemCount(): Int {
        return petani?.size ? : 0
    }

    class PetaniHolder(view: View) : RecyclerView.ViewHolder(view) {
        lateinit var txtNama: TextView
        lateinit var txtJumlahLahan: TextView
        lateinit var txtAlamat: TextView
        lateinit var txtKelurahan: TextView

        fun bindPetani(petani: DataItem?) {
            itemView.apply {
                txtNama = findViewById(R.id.nama)
                txtJumlahLahan = findViewById(R.id.jumlah_lahan)
                txtAlamat = findViewById(R.id.alamat)
                txtKelurahan = findViewById(R.id.kelurahan)

                txtNama.text = petani.nama
                txtJumlahLahan.text = petani.jumlahLahan
                txtAlamat.text = petani.alamat
                txtKelurahan.text = petani.kelurahan
            }
        }
    }
}