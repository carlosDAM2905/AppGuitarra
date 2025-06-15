package com.example.appguitarra.ui.animacion

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.airbnb.lottie.compose.*

/**muestra una animación Lottie desde el directorio assets creado para guardar las animaciones .json. Se puede reutilizar en cada pantalla de actividad y permite modificar su estilo (tamaño, alineación...) y el numero de veces que se repite la animación como confeti o indefinidamente como los guitarristas .
 */
@Composable
fun AnimacionLottie(
    nombreAnimacion: String,
    modifier: Modifier = Modifier,
    repeticiones: Int = LottieConstants.IterateForever
) {
    //Carga la animación desde assets sola una vez con remember
    val composicion by rememberLottieComposition(LottieCompositionSpec.Asset(nombreAnimacion))

    //controla el progreso de la animación de forma automatica
    val progreso by animateLottieCompositionAsState(
        composition = composicion,
        iterations = repeticiones
    )
    //reproduce la animación en la pantalla
    LottieAnimation(
        composition = composicion,
        progress = { progreso },
        modifier = modifier
    )
}
