package com.diaz.rodrigo.teceatapp

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

private const val DATABASE_NAME = "RestauranteDB"
private const val DATABASE_VERSION = 1
private const val TABLE_NAME = "restaurantes"

private const val COLUMN_ID = "id"
private const val COLUMN_NAME = "nombre_restaurante"
private const val COLUMN_ADDRESS = "direccion"
private const val COLUMN_PHONE = "telefono"
private const val COLUMN_OWNER = "nombre_dueno"
private const val COLUMN_EMAIL = "correo"
private const val COLUMN_PASSWORD = "contrasena"

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = """
            CREATE TABLE $TABLE_NAME (
                $COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $COLUMN_NAME TEXT,
                $COLUMN_ADDRESS TEXT,
                $COLUMN_PHONE TEXT,
                $COLUMN_OWNER TEXT,
                $COLUMN_EMAIL TEXT,
                $COLUMN_PASSWORD TEXT
            )
        """.trimIndent()

        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun insertRestaurante(nombre: String, direccion: String, telefono: String, dueno: String, correo: String, contrasena: String): Long {
        val db = writableDatabase
        val contentValues = ContentValues()

        contentValues.put(COLUMN_NAME, nombre)
        contentValues.put(COLUMN_ADDRESS, direccion)
        contentValues.put(COLUMN_PHONE, telefono)
        contentValues.put(COLUMN_OWNER, dueno)
        contentValues.put(COLUMN_EMAIL, correo)
        contentValues.put(COLUMN_PASSWORD, contrasena)

        return db.insert(TABLE_NAME, null, contentValues)
    }

    fun getAllRestaurantes(): MutableList<String> {
        val db = readableDatabase
        val listaRestaurantes = mutableListOf<String>()

        val query = "SELECT * FROM $TABLE_NAME"
        val cursor = db.rawQuery(query, null)

        if (cursor.moveToFirst()) {
            do {
                val nombre = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_NAME))
                val direccion = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_ADDRESS))
                val telefono = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_PHONE))
                val dueno = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_OWNER))
                val correo = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_EMAIL))
                listaRestaurantes.add("Nombre: $nombre\nDirección: $direccion\nTeléfono: $telefono\nDueño: $dueno\nCorreo: $correo")
            } while (cursor.moveToNext())
        }

        cursor.close()
        return listaRestaurantes
    }
}


