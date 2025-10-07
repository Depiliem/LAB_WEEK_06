package com.example.lab_week_06

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_week_06.model.CatModel

class CatAdapter(
    private val layoutInflater: LayoutInflater,
    private val imageLoader: ImageLoader
) : RecyclerView.Adapter<CatViewHolder>() {

    // Mutable list untuk menyimpan semua data kucing
    private val cats = mutableListOf<CatModel>()

    // Fungsi untuk memperbarui data pada adapter
    fun setData(newCats: List<CatModel>) {
        cats.clear()
        cats.addAll(newCats)
        // Memberi tahu adapter bahwa data telah berubah
        notifyDataSetChanged()
    }

    // Membuat ViewHolder baru saat RecyclerView memerlukan item baru
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val view = layoutInflater.inflate(R.layout.item_list, parent, false)
        return CatViewHolder(view, imageLoader)
    }

    // Mengembalikan jumlah item di daftar
    override fun getItemCount(): Int = cats.size

    // Mengikat data ke ViewHolder yang sesuai
    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        // holder.bindData() berasal dari class CatViewHolder
        holder.bindData(cats[position])
    }
}
