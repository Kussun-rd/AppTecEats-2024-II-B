package com.diaz.rodrigo.teceatapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RestauranteAdapter(private val restaurantes: List<Restaurante>) :
    RecyclerView.Adapter<RestauranteAdapter.RestauranteViewHolder>() {

    class RestauranteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val fotoRestauranteImageView: ImageView = itemView.findViewById(R.id.fotoRestauranteImageView)
        val nombreRestauranteTextView: TextView = itemView.findViewById(R.id.nombreRestauranteTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestauranteViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_restaurante, parent, false)
        return RestauranteViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RestauranteViewHolder, position: Int) {
        val restaurante = restaurantes[position]
        holder.fotoRestauranteImageView.setImageResource(restaurante.foto)
        holder.nombreRestauranteTextView.text = restaurante.nombre

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetalleRestauranteActivity::class.java)
            intent.putExtra("restaurante", restaurante)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return restaurantes.size
    }
}