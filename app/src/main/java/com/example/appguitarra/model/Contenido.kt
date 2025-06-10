package com.example.appguitarra.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contenido")
data class Contenido(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val titulo: String,
    val descripcion: String,
    val tipo: String,
    val url: String?,
    val premium: Boolean
)