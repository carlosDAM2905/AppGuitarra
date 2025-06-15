package com.example.appguitarra.ui.actividades

import android.util.Log
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.appguitarra.R
import com.example.appguitarra.data.AppDatabase
import com.example.appguitarra.data.AppSesion
import com.example.appguitarra.model.Progreso
import com.example.appguitarra.navigation.Rutas
import com.example.appguitarra.ui.actividades.componentesactividades.PreguntaInteractiva
import com.example.appguitarra.ui.actividades.componentesactividades.preguntasModosJonicos
import com.example.appguitarra.ui.animacion.AnimacionLottie
import com.example.appguitarra.utils.TitulosContenido

@Composable
fun PantallaActividadModosJonicos(navController: NavController) {
    // Estado actual de la pregunta (índice en la lista)
    var preguntaActual by rememberSaveable { mutableStateOf(0) }

    // Opción seleccionada por el usuario (si hay)
    var respuestaSeleccionada by rememberSaveable { mutableStateOf<String?>(null) }

    // Si se debe mostrar el resultado tras responder
    var mostrarResultado by rememberSaveable { mutableStateOf(false) }

    // Número de respuestas correctas acumuladas
    var aciertos by rememberSaveable { mutableStateOf(0) }

    // Marca si el usuario ha terminado todas las preguntas
    var finalizado by rememberSaveable { mutableStateOf(false) }

    // Contexto actual de la app (para acceder a la base de datos)
    val context = LocalContext.current

    // Pregunta actual y comprobación de si se ha respondido correctamente
    val pregunta = preguntasModosJonicos[preguntaActual]
    val esCorrecta = respuestaSeleccionada == pregunta.correcta

    // ──────────────────────────
    // PANTALLA FINAL DE RESULTADOS
    // ──────────────────────────
    if (finalizado) {
        // Se aprueba si se aciertan al menos la mitad de las preguntas
        val aprobado = aciertos >= preguntasModosJonicos.size / 2

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = WindowInsets.statusBars.asPaddingValues().calculateTopPadding() + 16.dp,
                    start = 32.dp,
                    end = 32.dp,
                    bottom = 32.dp
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Muestra "APROBADO" o "SUSPENDIDO"
            Text(
                text = stringResource(
                    if (aprobado) R.string.actividad_aprobada else R.string.actividad_suspendida
                ),
                fontSize = 22.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                color = if (aprobado) Color(0xFF1A6D1A) else Color(0xFFAF1E1E)
            )

            // Muestra el número de aciertos sobre total
            Text(
                text = stringResource(
                    R.string.actividad_resumen,
                    aciertos,
                    preguntasModosJonicos.size
                ),
                modifier = Modifier
                    .padding(top = 24.dp)
                    .fillMaxWidth(),
                fontSize = 18.sp,
                color = Color.DarkGray,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(24.dp))
            // Si aprueba, se guarda el progreso en la base de datos y se muestran animaciones
            if (aprobado) {
                LaunchedEffect(Unit) {
                    val usuario = AppSesion.usuarioActual
                    if (usuario != null) {
                        val db = AppDatabase.getDatabase(context)
                        val contenido =
                            db.contenidoDao().obtenerPorTitulo(TitulosContenido.MODOS_JONICOS)
                        if (contenido != null) {
                            val progresoExistente = db.progresoDao().obtenerProgreso(usuario.id, contenido.id)

                            if (progresoExistente == null) {
                                db.progresoDao().insertar(
                                    Progreso(
                                        idUsuario = usuario.id,
                                        idContenido = contenido.id,
                                        completado = true,
                                        fechaCompletado = System.currentTimeMillis()
                                    )
                                )
                                Log.d("Progreso", "progreso guardado para usuario ${usuario.id} en contenido ${contenido.id}")
                            } else {
                                Log.d("Progreso", "el progreso ya existía, no se volvió a guardar")
                            }

                        } else {
                            Log.e(
                                "Progreso",
                                "Contenido no encontrado: ${TitulosContenido.MODOS_JONICOS}"
                            ) // si no se guarda el contenido lo vemos en el logcat
                        }

                    }
                }

                // Animación de confeti y guitarrista
                AnimacionLottie("confetti.json", modifier = Modifier.size(300.dp), repeticiones = 3)
                Spacer(modifier = Modifier.height(16.dp))
                AnimacionLottie(
                    "guitarrista1.json",
                    modifier = Modifier.size(250.dp),
                    repeticiones = 1
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Botón para volver a la pantalla principal
            Button(onClick = {
                navController.navigate(Rutas.PRINCIPAL) {
                    popUpTo(Rutas.PRINCIPAL) { inclusive = true }
                    launchSingleTop = true
                }
            }) {
                Text(stringResource(R.string.volver_inicio))
            }
        }
        return // Termina aquí el composable si se ha finalizado
    }

    // ──────────────────────────
    //  PANTALLA DE PREGUNTAS
    // ──────────────────────────
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        // Título superior de la actividad
        Text(
            text = stringResource(R.string.titulo_actividad_modos_jonicos),
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp, bottom = 16.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Componente que muestra la pregunta actual con animación
        AnimatedContent(
            targetState = preguntaActual,
            transitionSpec = {
                slideInHorizontally { it } togetherWith slideOutHorizontally { -it }
            },
            label = "TransiciónPregunta"
        ) { index ->
            PreguntaInteractiva(
                pregunta = preguntasModosJonicos[index],
                respuestaSeleccionada = respuestaSeleccionada,
                mostrarResultado = mostrarResultado,
                onSeleccionar = {
                    respuestaSeleccionada = it
                    mostrarResultado = true
                }
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Botón "Siguiente" o "Finalizar" visible tras responder
        if (mostrarResultado) {
            Button(
                onClick = {
                    if (esCorrecta) aciertos++
                    if (preguntaActual < preguntasModosJonicos.lastIndex) {
                        preguntaActual++
                        respuestaSeleccionada = null
                        mostrarResultado = false
                    } else {
                        finalizado = true
                    }
                },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text(
                    text = stringResource(
                        id = if (preguntaActual < preguntasModosJonicos.lastIndex)
                            R.string.boton_siguiente
                        else
                            R.string.boton_finalizar
                    )
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewPantallaActividadModosJonicos() {
    PantallaActividadModosJonicos(navController = rememberNavController())
}
