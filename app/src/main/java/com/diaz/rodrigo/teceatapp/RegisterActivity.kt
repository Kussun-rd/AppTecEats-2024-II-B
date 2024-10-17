package com.diaz.rodrigo.teceatapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    // Instancia del helper para la base de datos
    lateinit var dbHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Inicializamos el helper
        dbHelper = DatabaseHelper(this)

        // Referencias a los campos del formulario
        val restaurantName = findViewById<EditText>(R.id.restaurantName)
        val restaurantAddress = findViewById<EditText>(R.id.restaurantAddress)
        val restaurantPhone = findViewById<EditText>(R.id.restaurantPhoneNumber)
        val ownerName = findViewById<EditText>(R.id.ownerName)
        val ownerEmail = findViewById<EditText>(R.id.ownerEmail)
        val password = findViewById<EditText>(R.id.ownerPassword)
        val registerButton = findViewById<Button>(R.id.registerButton)


        // Acción del botón para guardar los datos en la base de datos
        registerButton.setOnClickListener {
            val nombre = restaurantName.text.toString()
            val direccion = restaurantAddress.text.toString()
            val telefono = restaurantPhone.text.toString()
            val dueno = ownerName.text.toString()
            val correo = ownerEmail.text.toString()
            val contrasena = password.text.toString()

            // Insertamos los datos en la base de datos
            val id = dbHelper.insertRestaurante(nombre, direccion, telefono, dueno, correo, contrasena)

            if (id > 0) {
                Toast.makeText(this, "Restaurante registrado con éxito!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Error al registrar restaurante.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}





