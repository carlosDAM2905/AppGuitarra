package com.example.appguitarra.ui.actividades

import androidx.compose.animation.AnimatedContent
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
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
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
    ),
    PreguntaArmadura(
        R.drawable.armadura_de_ab,
        listOf("Ab", "Bb", "F"),
        "Ab",
        "La armadura mostrada tiene 4 bemoles (Bb, Eb, Ab y Db), lo que corresponde a Ab Mayor."
    ),
    PreguntaArmadura(
        R.drawable.armadura_de_eb,
        listOf("Eb", "F", "Bb"),
        "Eb",
        "La armadura de Eb Mayor tiene tres bemoles: Bb, Eb y Ab. Es la armadura mostrada en la imagen."
    ),
    PreguntaArmadura(
        R.drawable.armadura_de_f,
        listOf("C", "F", "G"),
        "F",
        "La armadura de F Mayor tiene un solo bemol (Bb), como se ve en la imagen."
    ),
    PreguntaArmadura(
        R.drawable.true_false,
        listOf("Verdadero", "Falso"),
        "Falso",
        "La afirmación sobre Ab es incorrecta: Ab tiene cuatro bemoles, no dos. Por tanto, la imagen contiene un error."
    )


)

@Composable
fun PantallaActividadArmadura(navController: NavController) {
    var preguntaActual by remember { mutableStateOf(0) }
    var respuestaSeleccionada by remember { mutableStateOf<String?>(null) }
    var mostrarResultado by remember { mutableStateOf(false) }

    var aciertos by remember { mutableStateOf(0) }
    var finalizado by remember { mutableStateOf(false) }

    val pregunta = preguntas[preguntaActual]
    val esCorrecta = respuestaSeleccionada == pregunta.correcta

    if (finalizado) {
        val aprobado = aciertos >= preguntas.size / 2

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Título
            Text(
                text = if (aprobado) "🎉 ¡Has superado la actividad!" else "😢 No has alcanzado el mínimo.",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = if (aprobado) Color(0xFF1A6D1A) else Color(0xFFAF1E1E)
            )

            Text(
                text = "Has acertado $aciertos/${preguntas.size} preguntas.",

                modifier = Modifier
                    .padding(top = 24.dp)
                    .fillMaxWidth(),
                fontSize = 18.sp,
                color = Color.DarkGray,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(24.dp))

            if (aprobado) {
                ConfetiAnimacion2(modifier = Modifier.size(300.dp))
                Spacer(modifier = Modifier.height(16.dp))
                Guitarrista2Animacion(modifier = Modifier.size(200.dp))
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
            val pregunta = preguntas[index]
            val esCorrectaPregunta = respuestaSeleccionada == pregunta.correcta

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
        }


            Spacer(modifier = Modifier.height(24.dp))

            if (mostrarResultado) {
                Button(
                    onClick = {
                        if (esCorrecta) aciertos++

                        if (preguntaActual < preguntas.lastIndex) {
                            preguntaActual++
                            respuestaSeleccionada = null
                            mostrarResultado = false
                        } else {
                            finalizado = true
                        }
                    },
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    Text(if (preguntaActual < preguntas.lastIndex) "Siguiente" else "Finalizar")
                }
            }
        }
    }

    @Composable
    fun ConfetiAnimacion2(modifier: Modifier = Modifier) {
        val composition by rememberLottieComposition(LottieCompositionSpec.Asset("confetti.json"))
        val progress by animateLottieCompositionAsState(
            composition
            = composition,
            iterations = 3
        )

        LottieAnimation(
            composition = composition,
            progress = { progress },
            modifier = modifier
        )
    }

    @Composable
    fun Guitarrista2Animacion(modifier: Modifier = Modifier) {
        val composition by rememberLottieComposition(LottieCompositionSpec.Asset("guitarrista_woman.json"))
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
