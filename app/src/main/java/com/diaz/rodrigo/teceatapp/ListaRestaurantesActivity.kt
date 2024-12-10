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

        val restaurantes = obtenerRestaurantes()
        val platosRecomendados = obtenerPlatosRecomendados()

        listaRestaurantesRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        listaRestaurantesRecyclerView.adapter = RestauranteAdapter(restaurantes)

        platosRecomendadosRecyclerView.layoutManager = LinearLayoutManager(this)
        platosRecomendadosRecyclerView.adapter = PlatoAdapter(platosRecomendados)
    }

    private fun obtenerRestaurantes(): List<Restaurante> {
        return listOf(
            Restaurante(
                "Punto y Coma",
                "Disfruta de nuestra amplia variedad de comidas",
                R.drawable.punto_coma,
                "Av. Cascanueces",
                "970732319",
                true,
                listOf(
                    Plato("Entrada", "Causa de Pollo", "Causa Rellena de Verduras y sabroso Pollo", 5.00, 4.5f, "Punto y Coma", R.drawable.causa_pollo),
                    Plato("Entrada", "Wantan Frito", "5 piezas de Wantan acompañado con tamarindo", 3.00, 3.5f, "Punto y Coma", R.drawable.wantan_frito),
                    Plato("Entrada", "Ensalada de Palta", "Ensalada De Palta, con pedazos de Tomate", 4.00, 2.5f, "Punto y Coma", R.drawable.ensalada_palta),
                    Plato("Plato", "Arroz con Pollo", "Rico Pollo acompañado con verduras", 7.00, 4.5f, "Punto y Coma", R.drawable.arroz_pollo),
                    Plato("Plato", "Aji de Pollo", "Arroz acompañado de un rico aji con pollo", 8.00, 4.0f, "Punto y Coma", R.drawable.milanesa_pollo),
                    Plato("Plato", "Arroz Chaufa", "Rico Arroz chaufa", 8.00, 5f, "Punto y Coma", R.drawable.arroz_chaufa),
                    Plato("Bebidas", "Inka Cola", "Inka Cola personal de 500ml", 2.50, 5f, "Punto y Coma", R.drawable.inka_cola),
                    Plato("Bebidas", "Coca Cola", "Coca Cola personal de 500ml", 2.50, 4.5f, "Punto y Coma", R.drawable.coca_cola),
                    Plato("Bebidas", "Chicha Morada", "Una jarra de chica refrescante", 3.00, 4.5f, "Punto y Coma", R.drawable.chicha_morada),
                ),
                "Av. Cascanueces Mz D-14 Lt 5, Santa Anita 15011"
            ),

            Restaurante(
                "Club Gourmet",
                "Disfruta de nuestros postres, bebidas y nuestro ambiente agradable",
                R.drawable.club_gourmet,
                "En las instalaciones de Tecsup",
                "(01) 3173900",
                "(01) 3173900, referencial",
                true,
                listOf(
                    Plato("Ensaladas", "Ensalada Cheff", "Lechuga, tomate, pepino, huevo, jamón, queso fresco y filete de pollo a la plancha", 10.00, 4.5f, "Club Gourmet", R.drawable.ensalada_chef),
                    Plato("Ensaladas", "Ensalada Capresse", "Lechuga, tomate, albahaca, queso y pollo deshilachado", 10.00, 3.5f, "Club Gourmet", R.drawable.ensalada_capresse),
                    Plato("Ensaladas", "Ensalada California", "Lechuga, tomate, pepino, palta, cebolla blanca, aceitunas, queso y filete de pollo a la plancha", 12.00, 2.5f, "Club Gourmet", R.drawable.ensalada_california),
                    Plato("Sandwiches", "Pan con Pollo Deshilachado", "Con papas al hilo y ensalada", 6.00, 4.5f, "Club Gourmet", R.drawable.pan_pollo),
                    Plato("Sandwiches", "Mixto Simple", "Pan puliman con jamón inglés y queso dambo", 5.50, 4.0f, "Club Gourmet", R.drawable.mixto_simple),
                    Plato("Sandwiches", "Croissant Mixto", "Pan hojaldrado con jamón inglés y queso", 5.00, 5f, "Club Gourmet", R.drawable.croissant_mixto),
                    Plato("Bebidas", "Infusión", "Té, hierba luisa, manzanilla o anis", 2.00, 5f, "Club Gourmet", R.drawable.infusion),
                    Plato("Bebidas", "Chica Morada", "Un vaso de chica refrescante", 3.00, 4.5f, "Club Gourmet", R.drawable.chicha_morada),
                    Plato("Bebidas", "Jugo de Naranja", "Un vaso de jugo de naranja refrescante", 5.00, 4.5f, "Club Gourmet", R.drawable.jugo_naranja),
                ),
                "Santa Anita, Av. Cascanueces 2221, Lima 15011"
            ),
            Restaurante(
                "Comedor de Tecsup",
                "Disfruta de nuestra amplia variedad de comidas",
                R.drawable.comedor_tecsup,
                "En las instalaciones de Tecsup",
                "(01) 3173900",

                "(01) 3173900, referencial",
                true,
                listOf(
                    Plato("Entrada", "Tequeños", "Tequeños con relleno de hot-dog", 2.00, 4.5f, "Comedor de Tecsup", R.drawable.tequenos_entrada),
                    Plato("Entrada", "Ocopa", "Papas con salsa de huacatay, ají amarillo y queso", 3.00, 3.5f, "Comedor de Tecsup", R.drawable.ocopa),
                    Plato("Entrada", "Sopa Aguadito", "Sopa ligera de arroz, pollo, cilantro y pimiento", 4.00, 2.5f, "Comedor de Tecsup", R.drawable.sopa_aguadito),
                    Plato("Plato", "Arroz con Mariscos", "Arroz con una variedad de mariscos", 7.00, 4.5f, "Comedor de Tecsup", R.drawable.arroz_mariscos),
                    Plato("Plato", "Alverjita partida", "Guiso de guisantes partidos con carne o pollo", 5.00, 4.0f, "Comedor de Tecsup", R.drawable.alverjita_partida),
                    Plato("Plato", "Seco de Pollo", "Pollo en salsa de cilantro, ají y especias, acompañado de arroz", 8.00, 5f, "Punto y Coma", R.drawable.seco_pollo),
                    Plato("Bebidas", "Vaso de Carambola", "Bebida refrescante de carambola", 1.00, 5f, "Comedor de Tecsup", R.drawable.bebida_carambola),
                    Plato("Bebidas", "Vaso de Emoliente", "Infusión refrescante", 1.00, 4.5f, "Comedor de Tecsup", R.drawable.bebida_emoliente),
                    Plato("Bebidas", "Vaso de Muña", "Infusión de hojas de muña, endulzada con azúcar", 1.00, 4.5f, "Comedor de Tecsup", R.drawable.bebida_muna),
                ),
                "Santa Anita, Av. Cascanueces 2221, Lima 15011"
            ),
        )
    }

    private fun obtenerPlatosRecomendados(): List<Plato> {
        return listOf(
            Plato("Platos Extra", "Salchipapa", "Papas fritas acompañadas de salchichas cortadas en rodajas", 9.0, 4.7f, "Punto y Coma Y Club Gourmet", R.drawable.salchipapa),
            Plato("Platos Extra", "Pollo Broaster", "Pollo frito crujiente acompañado de papas fritas", 12.0, 4.7f, "Punto y Coma y Comedor de Tecsup", R.drawable.pollo_broaster),
            Plato("Platos Extra", "Triples Completos", "Rellenos de pollo, jamón, lechuga, tomate, mayonesa", 5.0, 4.7f, "Club Gourmet y Comedor de Tecsup", R.drawable.triples_completos),
            Plato("Platos Extra", "Alitas Acevichadas", "Alitas de pollo fritas y cubiertas con una salsa inspirada en el ceviche", 8.0, 4.7f, "Punto y Coma", R.drawable.alitas_acevichadas),
            Plato("Platos Extra", "Ensalada Rusa", "Ensalada de papa, zanahoria y guisantes, mezclada con mayonesa", 3.0, 4.7f, "Punto y Coma", R.drawable.ensalada_rusa),
        )
    }
}