package com.diaz.rodrigo.teceatapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.net.URLEncoder

class DetalleRestauranteActivity : AppCompatActivity() {

    private lateinit var fotoRestauranteImageView: ImageView
    private lateinit var nombreRestauranteTextView: TextView
    private lateinit var descripcionRestauranteTextView: TextView
    private lateinit var ubicacionTextView: TextView
    private lateinit var telefonoTextView: TextView
    private lateinit var entregaTextView: TextView
    private lateinit var menuRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_restaurante)

        fotoRestauranteImageView = findViewById(R.id.fotoRestauranteImageView)
        nombreRestauranteTextView = findViewById(R.id.nombreRestauranteTextView)
        descripcionRestauranteTextView = findViewById(R.id.descripcionRestauranteTextView)
        ubicacionTextView = findViewById(R.id.ubicacionTextView)
        telefonoTextView = findViewById(R.id.telefonoTextView)
        entregaTextView = findViewById(R.id.entregaTextView)
        menuRecyclerView = findViewById(R.id.menuRecyclerView)

        val restaurante = intent.getParcelableExtra<Restaurante>("restaurante")

        if (restaurante != null) {
            try {
                fotoRestauranteImageView.setImageResource(restaurante.foto)
                nombreRestauranteTextView.text = restaurante.nombre
                descripcionRestauranteTextView.text = restaurante.descripcion
                ubicacionTextView.text = restaurante.ubicacion
                telefonoTextView.text = restaurante.telefono
                entregaTextView.text = if (restaurante.entregaEnCampus) "Entrega en Campus" else "No hay entrega en Campus"

                menuRecyclerView.layoutManager = LinearLayoutManager(this)
                menuRecyclerView.adapter = PlatoAdapter(restaurante.menu)

            } catch (e: Exception) {
                Log.e("DetalleRestaurante", "Error al mostrar los datos del restaurante", e)
            }
        } else {
            Log.e("DetalleRestaurante", "Restaurante es nulo")
        }
    }
    fun onUbicacionClick(view: View) {
        val restaurante = intent.getParcelableExtra<Restaurante>("restaurante")
        if (restaurante != null) {
            val ubicacion = "Av. Cascanueces Mz D-14 Lt 5, Santa Anita 15011"
            val gmmIntentUri = Uri.parse("geo:0,0?q=${URLEncoder.encode(ubicacion, "UTF-8")}")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }
    }

    fun onTelefonoClick(view: View) {
        val restaurante = intent.getParcelableExtra<Restaurante>("restaurante")
        if (restaurante != null) {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:${restaurante.telefono}")
            startActivity(intent)
        }
    }
}