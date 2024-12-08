package com.diaz.rodrigo.teceatapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListaRestaurantesActivity : AppCompatActivity() {

    private lateinit var listaRestaurantesRecyclerView: RecyclerView
    private lateinit var platosRecomendadosRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_restaurantes)

        listaRestaurantesRecyclerView = findViewById(R.id.listaRestaurantesRecyclerView)
        platosRecomendadosRecyclerView = findViewById(R.id.platosRecomendadosRecyclerView)

        // Aquí debes obtener la lista de restaurantes y platos recomendados
        val restaurantes = obtenerRestaurantes() // Reemplaza con tu lógica para obtener los datos
        val platosRecomendados = obtenerPlatosRecomendados() // Reemplaza con tu lógica

        listaRestaurantesRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        listaRestaurantesRecyclerView.adapter = RestauranteAdapter(restaurantes)

        platosRecomendadosRecyclerView.layoutManager = LinearLayoutManager(this)
        platosRecomendadosRecyclerView.adapter = PlatoAdapter(platosRecomendados)
    }

    // Función de ejemplo para obtener la lista de restaurantes (reemplázala con tu lógica)
    private fun obtenerRestaurantes(): List<Restaurante> {
        return listOf(
            Restaurante(
                "Punto y Coma",
                "Disfruta de nuestra amplia variedad de comidas",
                R.drawable.punto_coma, // Reemplaza con el ID de tu drawable
                "Av. Cascanueces",
                "945564545",
                true,
                listOf(
                    Plato("Arroz con Pollo", "Rico Pollo acompañado con verduras", 7.00, 4.5f, "Punto y Coma", R.drawable.arroz_pollo),
                    Plato("Aji de Pollo", "Arroz acompañado de un rico aji con pollo", 8.00, 4.0f, "Punto y Coma", R.drawable.aji_pollo)
                )
            ),
            // ... más restaurantes
        )
    }

    // Función de ejemplo para obtener la lista de platos recomendados (reemplázala con tu lógica)
    private fun obtenerPlatosRecomendados(): List<Plato> {
        return listOf(
            Plato("Tequeños", "Tequeños con relleno de hot-dog", 8.0, 4.7f, "Entradas en Punto y Coma", R.drawable.tequenos_entrada), // Reemplaza con IDs de drawables
            // ... más platos recomendados
        )
    }
}