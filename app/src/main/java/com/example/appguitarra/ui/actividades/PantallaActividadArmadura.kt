package com.example.appguitarra.ui.actividades

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.appguitarra.R
import com.example.appguitarra.navigation.Rutas

// Modelo de pregunta
data class PreguntaArmadura(
    val imagen: Int,
    val opciones: List<String>,
    val correcta: String,
    val explicacion: String
)

// Lista de preguntas
val preguntas = listOf(
    PreguntaArmadura(
        R.drawable.armadura_3_sostenidos,
        listOf("G", "D", "A"),
        "A",
        "La armadura de 3 sostenidos (F♯, C♯ y G♯) corresponde a A Mayor."
    ),
    PreguntaArmadura(
        R.drawable.armadura_2_sostenidos,
        listOf("E", "D", "C"),
        "D",
        "La armadura de 2 sostenidos (F♯ y C♯) corresponde a D Mayor."
    )
)

@Composable
fun PantallaActividadArmadura(navController: NavController) {
    var preguntaActual by remember { mutableStateOf(0) }
    var respuestaSeleccionada by remember { mutableStateOf<String?>(null) }
    var mostrarResultado by remember { mutableStateOf(false) }

    val pregunta = preguntas[preguntaActual]
    val esCorrecta = respuestaSeleccionada == pregunta.correcta

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Título
        Text(
            text = "Actividad: Identifica la armadura",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Pregunta con imagen y fondo dinámico
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = when {
                    !mostrarResultado -> Color.White
                    esCorrecta -> Color(0xFFDFF5DD)
                    else -> Color(0xFFFFE6E6)
                }
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = pregunta.imagen),
                    contentDescription = "Imagen de armadura",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp)
                )

                Spacer(modifier = Modifier.height(12.dp))

                pregunta.opciones.forEach { opcion ->
                    val color = when {
                        !mostrarResultado -> Color(0xFFE0ECF5)
                        opcion == pregunta.correcta -> Color(0xFFB4F0B4)
                        opcion == respuestaSeleccionada -> Color(0xFFF5B4B4)
                        else -> Color.LightGray
                    }

                    Button(
                        onClick = {
                            if (!mostrarResultado) {
                                respuestaSeleccionada = opcion
                                mostrarResultado = true
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = color,
                            contentColor = Color.Black
                        ),
                        enabled = !mostrarResultado
                    ) {
                        Text(opcion, fontSize = 18.sp)
                    }
                }

                if (mostrarResultado) {
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = if (esCorrecta) "✅ ¡Correcto! ${pregunta.explicacion}" else "❌ Incorrecto. ${pregunta.explicacion}",
                        color = if (esCorrecta) Color(0xFF1A6D1A) else Color(0xFFAF1E1E),
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        if (mostrarResultado) {
            Button(
                onClick = {
                    if (preguntaActual < preguntas.lastIndex) {
                        preguntaActual++
                        respuestaSeleccionada = null
                        mostrarResultado = false
                    } else {
                        navController.navigate(Rutas.TEORIA_ARMADURA)
                    }
                },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text(if (preguntaActual < preguntas.lastIndex) "Siguiente" else "Finalizar")
            }
        }
    }
}
