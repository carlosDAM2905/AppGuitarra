package com.example.appguitarra.ui.principal

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.appguitarra.R

@Composable
fun PantallaPrincipalImagen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Título
        Text(
            text = "Pantalla Principal",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 16.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxSize()
        ) {
            // Fondo de mástil con cuerdas tocables encima
            Box(
                modifier = Modifier
                    .weight(2.5f)
                    .fillMaxHeight()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.mastil_completo),
                    contentDescription = "Mástil de guitarra",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier.fillMaxSize()
                )

                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 36.dp), // ajusta según la imagen
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    repeat(6) { index ->
                        Box(
                            modifier = Modifier
                                .fillMaxHeight()
                                .width(30.dp)
                                .clickable {
                                    println("Cuerda ${index + 1} tocada")
                                }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.width(16.dp))

            // Texto lateral
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "← Toca una cuerda", fontSize = 16.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPantallaPruebaMastil() {
    PantallaPrincipalImagen()
}