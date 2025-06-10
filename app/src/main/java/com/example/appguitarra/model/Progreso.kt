package com.example.appguitarra.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "progreso",
    foreignKeys = [
        ForeignKey(
            entity = Usuario::class,
            parentColumns = ["id"],
            childColumns = ["idUsuario"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Contenido::class,
            parentColumns = ["id"],
            childColumns = ["idContenido"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Progreso(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val idUsuario: Int,
    val idContenido: Int,
    val completado: Boolean,
    val fechaCompletado: Long = System.currentTimeMillis()
)
