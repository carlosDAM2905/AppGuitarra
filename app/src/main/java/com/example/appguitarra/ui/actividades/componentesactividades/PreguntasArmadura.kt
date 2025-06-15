package com.example.appguitarra.ui.actividades.componentesactividades

import com.example.appguitarra.R

// Lista de preguntas específicas para la actividad de armadura
val preguntasArmadura = listOf(
    Pregunta(
        imagen = R.drawable.armadura_3_sostenidos,
        opciones = listOf("G", "D", "A"),
        correcta = "A",
        explicacion = R.string.explicacion_pregunta1
    ),
    Pregunta(
        imagen = R.drawable.armadura_2_sostenidos,
        opciones = listOf("E", "D", "C"),
        correcta = "D",
        explicacion = R.string.explicacion_pregunta2
    ),
    Pregunta(
        imagen = R.drawable.armadura_de_ab,
        opciones = listOf("Ab", "Bb", "F"),
        correcta = "Ab",
        explicacion = R.string.explicacion_pregunta3
    ),
    Pregunta(
        imagen = R.drawable.armadura_de_eb,
        opciones = listOf("Eb", "F", "Bb"),
        correcta = "Eb",
        explicacion = R.string.explicacion_pregunta4
    ),
    Pregunta(
        imagen = R.drawable.armadura_de_f,
        opciones = listOf("C", "F", "G"),
        correcta = "F",
        explicacion = R.string.explicacion_pregunta5
    ),
    Pregunta(
        imagen = R.drawable.true_false,
        opciones = listOf("Verdadero", "Falso"),
        correcta = "Falso",
        explicacion = R.string.explicacion_pregunta6
    )
)
