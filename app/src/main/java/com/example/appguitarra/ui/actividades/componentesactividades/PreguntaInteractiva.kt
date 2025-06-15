package com.example.appguitarra.ui.actividades.componentesactividades

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appguitarra.ui.animacion.AnimacionLottie

/**
 * Componente visual que muestra una pregunta con imagen, texto, opciones y animación de resultado.
 *
 * @param pregunta Objeto Pregunta con los datos (imagen, texto, opciones, correcta, explicación)
 * @param respuestaSeleccionada Opción marcada por el usuario (si hay)
 * @param mostrarResultado Si ya se ha pulsado una opción (true para mostrar resultado)
 * @param onSeleccionar Función a ejecutar cuando el usuario selecciona una opción
 */
@Composable
fun PreguntaInteractiva(
    pregunta: Pregunta,
    respuestaSeleccionada: String?,
    mostrarResultado: Boolean,
    onSeleccionar: (String) -> Unit
) {
    val esCorrecta = respuestaSeleccionada == pregunta.correcta

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
            // Mostrar imagen si existe
            pregunta.imagen?.let {
                Image(
                    painter = painterResource(id = it),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(max = 180.dp)
                )
                Spacer(modifier = Modifier.height(12.dp))
            }

            // Mostrar texto si existe
            pregunta.textoPregunta?.let {
                Text(
                    text = stringResource(id = it),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(12.dp))
            }

            // Mostrar opciones
            pregunta.opciones.forEach { opcion ->
                val color = when {
                    !mostrarResultado -> Color(0xFFE0ECF5)
                    opcion == pregunta.correcta -> Color(0xFFB4F0B4)
                    opcion == respuestaSeleccionada -> Color(0xFFF5B4B4)
                    else -> Color.LightGray
                }

                Button(
                    onClick = { if (!mostrarResultado) onSeleccionar(opcion) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = color,
                        contentColor = Color.Black
                    ),
                    enabled = !mostrarResultado
                ) {
                    Text(text = opcion, fontSize = 18.sp)
                }
            }

            // Mostrar animación y explicación si ya se ha respondido
            if (mostrarResultado) {
                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = stringResource(
                        id = if (esCorrecta) {
                            com.example.appguitarra.R.string.respuesta_correcta
                        } else {
                            com.example.appguitarra.R.string.respuesta_incorrecta
                        },
                        formatArgs = arrayOf(stringResource(pregunta.explicacion))
                    ),
                    color = if (esCorrecta) Color(0xFF1A6D1A) else Color(0xFFAF1E1E),
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(modifier = Modifier.height(16.dp))

                AnimacionLottie(
                    nombreAnimacion = if (esCorrecta) "acierto.json" else "fallo.json",
                    modifier = Modifier.size(60.dp),
                    repeticiones = 1
                )
            }
        }
    }
}
