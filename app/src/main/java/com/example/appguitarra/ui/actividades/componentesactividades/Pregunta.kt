package com.example.appguitarra.ui.actividades.componentesactividades


// Modelo de pregunta reutilizable para distintas actividades
data class Pregunta(
    val imagen: Int? = null,             // Imagen opcional (null si no hay imagen)
    val textoPregunta: Int? = null,      // Texto opcional (null si no hay texto)
    val opciones: List<String>,          // Opciones posibles de respuesta
    val correcta: String,                // Respuesta correcta
    val explicacion: Int                 // Texto explicativo de la respuesta
)



