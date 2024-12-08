package com.diaz.rodrigo.teceatapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PlatoAdapter(private val platos: List<Plato>) :
    RecyclerView.Adapter<PlatoAdapter.PlatoViewHolder>() {

    class PlatoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val fotoPlatoImageView: ImageView = itemView.findViewById(R.id.fotoPlatoImageView)
        val nombrePlatoTextView: TextView = itemView.findViewById(R.id.nombrePlatoTextView)
        val descripcionPlatoTextView: TextView = itemView.findViewById(R.id.descripcionPlatoTextView)
        val precioPlatoTextView: TextView = itemView.findViewById(R.id.precioPlatoTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlatoViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_plato, parent, false)
        return PlatoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PlatoViewHolder, position: Int) {
        val plato = platos[position]
        holder.fotoPlatoImageView.setImageResource(plato.foto)
        holder.nombrePlatoTextView.text = plato.nombre
        holder.descripcionPlatoTextView.text = plato.descripcion
        holder.precioPlatoTextView.text = "S/. ${plato.precio}"
    }

    override fun getItemCount(): Int {
        return platos.size
    }
}