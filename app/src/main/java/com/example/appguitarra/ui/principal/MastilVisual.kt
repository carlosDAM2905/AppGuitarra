import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appguitarra.model.notasExactas
import androidx.compose.foundation.layout.BoxWithConstraints

@Composable
fun MastilVisual(modifier: Modifier = Modifier, notaSeleccionada: String, onNotaClick: (String) -> Unit) {

    val cuerdas = 5
    val lineasHorizontales = 22

    BoxWithConstraints(
        modifier = modifier
            .fillMaxHeight()
    ) {
        val totalWidth = constraints.maxWidth.toFloat()
        val totalHeight = constraints.maxHeight.toFloat()
        val cellW = totalWidth / cuerdas
        val cellH = totalHeight / lineasHorizontales

        //  Canvas: cuerdas y trastes
        Canvas(modifier = Modifier.fillMaxSize()) {
            // Líneas verticales (cuerdas)
            for (i in 0..cuerdas) {
                val x = i * cellW
                drawLine(
                    color = Color.Black,
                    start = Offset(x, 0f),
                    end = Offset(x, size.height),
                    strokeWidth = 2f
                )
            }

            // Líneas horizontales (trastes)
            for (j in 0..lineasHorizontales) {
                val y = j * cellH
                drawLine(
                    color = Color.Black,
                    start = Offset(0f, y),
                    end = Offset(size.width, y),
                    strokeWidth = 1.8f
                )
            }
        }



            // 🎯 Notas en posiciones exactas
            notasExactas.forEach { nota ->
                val x = ((0.5f + (nota.offsetX ?: 0f)) / cuerdas) * totalWidth
                val y = (nota.yLine / lineasHorizontales) * totalHeight

                Box(
                    modifier = Modifier
                        .absoluteOffset(x = x.dp, y = y.dp)
                        .clickable{ onNotaClick(nota.texto)},
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = nota.texto,
                        fontSize = 10.sp,
                        color = if (nota.texto == notaSeleccionada) Color.Red else Color.Black
                    )
                }
            }
        }
    }

