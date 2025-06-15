package com.example.appguitarra.ui.actividades.componentesactividades



import com.example.appguitarra.R

// Lista de preguntas específicas para la actividad de Modos Jónicos
val preguntasModosJonicos = listOf(
    Pregunta(
        textoPregunta = R.string.pregunta1_modo_jonico_texto,
        opciones = listOf("Verdadero", "Falso"),
        correcta = "Verdadero",
        explicacion = R.string.explicacion_pregunta_modo_jonico1
    ),
    Pregunta(
        imagen = R.drawable.pregunta2_jonico,
        opciones = listOf("G jónica", "D jónica", "A jónica"),
        correcta = "G jónica",
        explicacion = R.string.explicacion_pregunta_modo_jonico2
    ),
    Pregunta(
        textoPregunta = R.string.pregunta3_modo_jonico_texto,
        opciones = listOf(
            "La cuerda A (quinta cuerda)",
            "La cuerda E (sexta cuerda)",
            "La cuerda D (cuarta cuerda)"
        ),
        correcta = "La cuerda A (quinta cuerda)",
        explicacion = R.string.explicacion_pregunta_modo_jonico3
    ),
    Pregunta(
        imagen = R.drawable.pregunta4_jonico,
        opciones = listOf("G (raíz en bordón)", "C (raíz en quinta)", "F (raíz en cuarta)"),
        correcta = "G (raíz en bordón)",
        explicacion = R.string.explicacion_pregunta_modo_jonico4
    ),
    Pregunta(
        imagen = R.drawable.pregunta5_jonico,
        opciones = listOf("Verdadero", "Falso"),
        correcta = "Falso",
        explicacion = R.string.explicacion_pregunta_modo_jonico5
    ),
    Pregunta(
        imagen = R.drawable.pregunta6_jonico,
        opciones = listOf("C (Do mayor)", "G (Sol mayor)", "F (Fa mayor)"),
        correcta = "C (Do mayor)",
        explicacion = R.string.explicacion_pregunta_modo_jonico6
    )
)
