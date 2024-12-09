package com.diaz.rodrigo.teceatapp

import android.os.Parcel
import android.os.Parcelable

data class Restaurante(
    val nombre: String,
    val descripcion: String,
    val foto: Int,
    val ubicacion: String,
    val telefono: String,
    val entregaEnCampus: Boolean,
    val menu: List<Plato>,
    val ubicacionEspecifica: String // Agrega este campo
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readByte() != 0.toByte(),
        parcel.createTypedArrayList(Plato.CREATOR)!!,
        parcel.readString()!! // Leer la ubicación específica
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombre)
        parcel.writeString(descripcion)
        parcel.writeInt(foto)
        parcel.writeString(ubicacion)
        parcel.writeString(telefono)
        parcel.writeByte(if (entregaEnCampus) 1 else 0)
        parcel.writeTypedList(menu)
        parcel.writeString(ubicacionEspecifica) // Escribir la ubicación específica
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Restaurante> {
        override fun createFromParcel(parcel: Parcel): Restaurante {
            return Restaurante(parcel)
        }

        override fun newArray(size: Int): Array<Restaurante?> {
            return arrayOfNulls(size)
        }
    }
}