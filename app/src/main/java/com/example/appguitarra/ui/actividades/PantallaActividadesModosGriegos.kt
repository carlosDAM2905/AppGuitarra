package com.example.appguitarra.ui.actividades

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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

//modelo de pregunta:
data class PreguntaModosGriegos(
    val imagen: Int,
    val opciones: List<String>,
    val correcta: String,
    val explicacion: String
)

//lista de preguntas:
val preguntasModosGriegos = listOf(
    PreguntaModosGriegos(
R.drawable.dorico,
        listOf("Jónico", "Dórico", "Frigio"),
        correcta = "Dórico",
        explicacion = "El acorde Dm7 se forma sobre el segundo grado (II) de la escala de Do mayor, lo que corresponde al modo Dórico."
    ),
    PreguntaModosGriegos(
        R.drawable.eolico,
        listOf("Eólico", "Locrio", "Jónico"),
        correcta = "Eólico",
        explicacion = "El modo Eólico se construye sobre el sexto grado (VI) de la escala mayor. En la tonalidad de Do, el sexto grado es La, y su acorde correspondiente es Am7."
    ),
    PreguntaModosGriegos(
        R.drawable.lidio,
        listOf("Mixolidio", "Lidio", "Frigio"),
        correcta = "Lidio",
        explicacion = "El modo Lidio se construye sobre el cuarto grado (IV) de la escala mayor. En la tonalidad de Do, el cuarto grado es Fa, y su acorde correspondiente es FM7."
    ),
    PreguntaModosGriegos(
        imagen = R.drawable.mixolidio,
        opciones = listOf("Eólico", "Locrio", "Mixolidio"),
        correcta = "Mixolidio",
        explicacion = "El modo Mixolidio se construye sobre el quinto grado (V) de la escala mayor. En la tonalidad de Do, ese grado es Sol, y su acorde correspondiente es G7."
    ),
    PreguntaModosGriegos(
        imagen = R.drawable.locrio,
        opciones = listOf("Frigio", "Locrio", "Dórico"),
        correcta = "Locrio",
        explicacion = "El modo Locrio se construye sobre el séptimo grado (VII) de la escala mayor. En la tonalidad de Do, ese grado es Si (B), y el acorde correspondiente es Bm7♭5."
    ),
    PreguntaModosGriegos(
        imagen = R.drawable.jonico,
        opciones = listOf("Jónico", "Dórico", "Mixolidio"),
        correcta = "Jónico",
        explicacion = "El modo Jónico se construye sobre el primer grado (I) de la escala mayor. En la tonalidad de Do, ese grado es Do (C), y el acorde correspondiente es Cmaj7."
    )

)

@Composable
fun PantallaActividadModosGriegos(navController: NavController) {
    var preguntaActual by remember { mutableStateOf(0) }
    var respuestaSeleccionada by remember { mutableStateOf<String?>(null) }
    var mostrarResultado by remember { mutableStateOf(false) }

    val pregunta = preguntasModosGriegos[preguntaActual]
    val esCorrecta = respuestaSeleccionada == pregunta.correcta

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Título
        Text(
            text = "Actividad: Identifica el modo griego",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Tarjeta con imagen y resultado
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
                    contentDescription = "Modo griego",
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
                    if (preguntaActual < preguntasModosGriegos.lastIndex) {
                        preguntaActual++
                        respuestaSeleccionada = null
                        mostrarResultado = false
                    } else {
                        navController.navigate(Rutas.TEORIA_MODOS_GRIEGOS)
                    }
                },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text(if (preguntaActual < preguntasModosGriegos.lastIndex) "Siguiente" else "Finalizar")
            }
        }
    }
}

