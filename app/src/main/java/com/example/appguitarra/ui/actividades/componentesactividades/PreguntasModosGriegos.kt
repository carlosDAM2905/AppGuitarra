package com.example.appguitarra.ui.actividades.componentesactividades


import com.example.appguitarra.R

// Lista de preguntas específicas para la actividad de Modos Griegos
val preguntasModosGriegos = listOf(
    Pregunta(
        imagen = R.drawable.dorico,
        opciones = listOf("Jónico", "Dórico", "Frigio"),
        correcta = "Dórico",
        explicacion = R.string.explicacion_modo_1
    ),
    Pregunta(
        imagen = R.drawable.eolico,
        opciones = listOf("Eólico", "Locrio", "Jónico"),
        correcta = "Eólico",
        explicacion = R.string.explicacion_modo_2
    ),
    Pregunta(
        imagen = R.drawable.lidio,
        opciones = listOf("Mixolidio", "Lidio", "Frigio"),
        correcta = "Lidio",
        explicacion = R.string.explicacion_modo_3
    ),
    Pregunta(
        imagen = R.drawable.mixolidio,
        opciones = listOf("Eólico", "Locrio", "Mixolidio"),
        correcta = "Mixolidio",
        explicacion = R.string.explicacion_modo_4
    ),
    Pregunta(
        imagen = R.drawable.locrio,
        opciones = listOf("Frigio", "Locrio", "Dórico"),
        correcta = "Locrio",
        explicacion = R.string.explicacion_modo_5
    ),
    Pregunta(
        imagen = R.drawable.jonico,
        opciones = listOf("Jónico", "Dórico", "Mixolidio"),
        correcta = "Jónico",
        explicacion = R.string.explicacion_modo_6
    )
)
