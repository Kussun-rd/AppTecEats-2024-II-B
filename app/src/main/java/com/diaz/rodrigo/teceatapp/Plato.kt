package com.diaz.rodrigo.teceatapp

import android.os.Parcel
import android.os.Parcelable

data class Plato(
    val titulo: String,
    val nombre: String,
    val descripcion: String,
    val precio: Double,
    val valoracion: Float,
    val restaurante: String,
    val foto: Int
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readDouble(),
        parcel.readFloat(),
        parcel.readString()!!,
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(titulo)
        parcel.writeString(nombre)
        parcel.writeString(descripcion)
        parcel.writeDouble(precio)
        parcel.writeFloat(valoracion)
        parcel.writeString(restaurante)
        parcel.writeInt(foto)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Plato> {
        override fun createFromParcel(parcel: Parcel): Plato {
            return Plato(parcel)
        }

        override fun newArray(size: Int): Array<Plato?> {
            return arrayOfNulls(size)
        }
    }
}