package com.example.appguitarra.ui.actividades

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.with
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.appguitarra.R
import com.example.appguitarra.navigation.Rutas

import com.airbnb.lottie.compose.* // animacion


data class PreguntaModosGriegos(
    val imagen: Int,
    val opciones: List<String>,
    val correcta: String,
    val explicacion: String
)

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
        R.drawable.mixolidio,
        listOf("Eólico", "Locrio", "Mixolidio"),
        correcta = "Mixolidio",
        explicacion = "El modo Mixolidio se construye sobre el quinto grado (V) de la escala mayor. En la tonalidad de Do, ese grado es Sol, y su acorde correspondiente es G7."
    ),
    PreguntaModosGriegos(
        R.drawable.locrio,
        listOf("Frigio", "Locrio", "Dórico"),
        correcta = "Locrio",
        explicacion = "El modo Locrio se construye sobre el séptimo grado (VII) de la escala mayor. En la tonalidad de Do, ese grado es Si (B), y el acorde correspondiente es Bm7♭5."
    ),
    PreguntaModosGriegos(
        R.drawable.jonico,
        listOf("Jónico", "Dórico", "Mixolidio"),
        correcta = "Jónico",
        explicacion = "El modo Jónico se construye sobre el primer grado (I) de la escala mayor. En la tonalidad de Do, ese grado es Do (C), y el acorde correspondiente es Cmaj7."
    )
)


@Composable
fun PantallaActividadModosGriegos(navController: NavController) {
    var preguntaActual by remember { mutableStateOf(0) }
    var respuestaSeleccionada by remember { mutableStateOf<String?>(null) }
    var mostrarResultado by remember { mutableStateOf(false) }
    var aciertos by remember { mutableStateOf(0) }
    var finalizado by remember { mutableStateOf(false) }

    val esCorrecta = respuestaSeleccionada == preguntasModosGriegos[preguntaActual].correcta

    if (finalizado) {
        val aprobado = aciertos >= preguntasModosGriegos.size / 2

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = if (aprobado) "🎉 ¡Has superado la actividad!" else "😢 No has alcanzado el mínimo.",
                fontSize = 22.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                color = if (aprobado) Color(0xFF1A6D1A) else Color(0xFFAF1E1E)
            )

            Text(
                text = "Has acertado $aciertos/${preguntasModosGriegos.size} preguntas.",

                modifier = Modifier
                    .padding(top = 24.dp)
                    .fillMaxWidth(),
                fontSize = 18.sp,
                color = Color.DarkGray,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(24.dp))

            if (aprobado) {
                ConfetiAnimacion(modifier = Modifier.size(300.dp))
                Spacer(modifier = Modifier.height(16.dp))
                GuitarristaAnimacion(modifier = Modifier.size(200.dp))
            }

            Spacer(modifier = Modifier.height(24.dp))

            Button(onClick = {
                navController.navigate(Rutas.PRINCIPAL)
            }) {
                Text("Volver al inicio")
            }
        }

        return // salir del Composable para no pintar más
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Actividad: Identifica el modo griego",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(24.dp))

        AnimatedContent(
            targetState = preguntaActual,
            transitionSpec = {
                slideInHorizontally { it } togetherWith slideOutHorizontally { -it }
            },
            label = "TransiciónPregunta"
        ) { index ->
            val pregunta = preguntasModosGriegos[index]
            val esCorrectaPregunta = respuestaSeleccionada == pregunta.correcta

            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = when {
                        !mostrarResultado -> Color.White
                        esCorrectaPregunta -> Color(0xFFDFF5DD)
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
                            text = if (esCorrectaPregunta) "✅ ¡Correcto! ${pregunta.explicacion}" else "❌ Incorrecto. ${pregunta.explicacion}",
                            color = if (esCorrectaPregunta) Color(0xFF1A6D1A) else Color(0xFFAF1E1E),
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        if (mostrarResultado) {
            Button(
                onClick = {
                    if (esCorrecta) aciertos++

                    if (preguntaActual < preguntasModosGriegos.lastIndex) {
                        preguntaActual++
                        respuestaSeleccionada = null
                        mostrarResultado = false
                    } else {
                        finalizado = true
                    }
                },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text(if (preguntaActual < preguntasModosGriegos.lastIndex) "Siguiente" else "Finalizar")
            }
        }
    }
}

@Composable
fun ConfetiAnimacion(modifier: Modifier = Modifier) {
    val composition by rememberLottieComposition(LottieCompositionSpec.Asset("confetti.json"))
    val progress by animateLottieCompositionAsState(composition
     = composition,
        iterations = 3)

    LottieAnimation(
        composition = composition,
        progress = { progress },
        modifier = modifier
    )
}

@Composable
fun GuitarristaAnimacion(modifier: Modifier = Modifier) {
    val composition by rememberLottieComposition(LottieCompositionSpec.Asset("guitarrista.json"))
    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations = LottieConstants.IterateForever
    )

    LottieAnimation(
        composition = composition,
        progress = { progress },
        modifier = modifier
    )
}



