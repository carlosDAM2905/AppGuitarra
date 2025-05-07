package com.example.appguitarra.ui.principal

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.appguitarra.R
import com.example.appguitarra.ui.theme.AppGuitarraTheme

@Composable
fun PantallaPrincipal() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFF8E7))
            .padding(16.dp)
    ) {
        Text(
            text = "Pantalla Principal",
            fontSize = 28.sp,
            color = Color.Black,
            modifier = Modifier
                .padding(bottom = 16.dp)
                .align(Alignment.CenterHorizontally)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // CUERDAS + FONDO MÁSTIL
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)
            ) {
                // Imagen del mástil detrás de las cuerdas
                val mastil: Painter = painterResource(id = R.drawable.mastil_fondo)

                Image(
                    painter = mastil,
                    contentDescription = "Fondo mástil",
                    contentScale = ContentScale.FillHeight,
                    modifier = Modifier
                        .fillMaxHeight()
                        .align(Alignment.CenterStart)
                        .zIndex(0f)
                )

                // Cuerdas encima del mástil
                Row(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(start = 10.dp)
                        .zIndex(1f),
                    horizontalArrangement = Arrangement.spacedBy(27.dp)
                ) {
                    repeat(6) {
                        Box(
                            modifier = Modifier
                                .width(3.dp)
                                .fillMaxHeight()
                                .background(Color.Gray)
                                .clickable {
                                    // Acción al tocar la cuerda
                                }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Toca una cuerda",
                    fontSize = 16.sp,
                    color = Color.DarkGray
                )
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

