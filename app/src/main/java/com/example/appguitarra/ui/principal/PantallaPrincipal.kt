package com.example.appguitarra.ui.principal

import MastilVisual
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appguitarra.R
import com.example.appguitarra.ui.theme.AppGuitarraTheme

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun PantallaPrincipal() {
    var submenuActivo by remember { mutableStateOf("Modos griegos") }
    var notaSeleccionada by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize()) {
        // 🧠 Menú superior compacto y responsivo con logo
        Column(

            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFE7F0F9), shape = RoundedCornerShape(0,0,30,30))
                .border(0.5.dp, color = Color (0xFF153B59), shape = RoundedCornerShape(0,0,30,30))
                .padding(1.dp)

        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier.fillMaxWidth()
            ) {

            }

            Spacer(modifier = Modifier.height(8.dp))

            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                listOf("Ciclo de 5ª/4ª", "Armadura armónica", "Modos griegos").forEach { item ->
                    val isSelected = submenuActivo == item
                    Button(
                        onClick = { submenuActivo = item },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (isSelected) Color(0xFFD0E4F7) else Color(0xFFE7F0F9),
                            contentColor = if (isSelected) Color(0xFF153B59) else Color(0xFF153B59)
                        ),
                        shape = RoundedCornerShape(50),
                        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 4.dp)
                    ) {
                        Text(
                            text = item,
                            fontSize = 13.sp,
                            color = Color(0xFF153B59)
                        )
                    }
                }
            }
        }

        // 🔽 Contenido principal
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            // 🎸 Mástil a la izquierda
            Box(
                modifier = Modifier
                    .width(100.dp)
                    .height(720.dp)
                    .background(Color.White, shape = RoundedCornerShape(16.dp))
                    .padding(8.dp)
            ) {
                MastilVisual(
                    notaSeleccionada = notaSeleccionada,
                    onNotaClick = { notaSeleccionada = it }
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            // 📑 Zona de información a la derecha
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
                    .background(Color.White, shape = RoundedCornerShape(16.dp))
                    .padding(12.dp),
                verticalArrangement = Arrangement.Top
            ) {
                when (submenuActivo) {
                    "Modos griegos" -> {
                        FlowRow(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            verticalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            listOf("C", "D", "E", "F", "G", "A", "B").forEach { nota ->
                                Button(
                                    onClick = { notaSeleccionada = nota },
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = if (notaSeleccionada == nota) Color(0xFFB4D4F0) else Color(0xFFE0ECF5)
                                    ),
                                    shape = RoundedCornerShape(50),
                                    contentPadding = PaddingValues(horizontal = 8.dp, vertical = 2.dp),
                                    modifier = Modifier.sizeIn(minWidth = 36.dp, minHeight = 28.dp)
                                ) {
                                    Text(text = nota, fontSize = 12.sp, color = Color(0xFF153B59))
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        Text(
                            text = if (notaSeleccionada.isNotEmpty()) "$notaSeleccionada – Nota en el diapasón" else "Pulsa una nota",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF153B59)
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = when (notaSeleccionada) {
                                "E" -> "La nota E (mi) se encuentra en varias cuerdas y es fundamental en la afinación estándar."
                                "A" -> "La nota A (la) también es parte de la afinación estándar, ubicada en la quinta cuerda."
                                "D" -> "La nota D (re) se sitúa en la cuarta cuerda abierta y aparece en muchas posiciones."
                                "G" -> "La nota G (sol) se encuentra abierta en la tercera cuerda."
                                "B" -> "La nota B (si) está en la segunda cuerda al aire."
                                "C" -> "La nota C (do) es frecuente en escalas mayores y se encuentra en varios trastes."
                                "F" -> "La nota F (fa) es semitono de E y aparece justo después en muchas cuerdas."
                                else -> "Selecciona una nota para ver su información."
                            },
                            fontSize = 14.sp,
                            color = Color(0xFF3E5060)
                        )
                    }

                    "Ciclo de 5ª/4ª" -> {
                        Text(
                            text = "Aquí irá el contenido visual o explicativo del ciclo de quintas y cuartas.",
                            fontSize = 14.sp,
                            color = Color(0xFF3E5060)
                        )
                    }

                    "Armadura armónica" -> {
                        Text(
                            text = "Aquí irá el contenido con armaduras de clave y sus alteraciones.",
                            fontSize = 14.sp,
                            color = Color(0xFF3E5060)
                        )
                    }
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun PreviewPantallaPrincipal() {
    AppGuitarraTheme {
        PantallaPrincipal()
    }
}
