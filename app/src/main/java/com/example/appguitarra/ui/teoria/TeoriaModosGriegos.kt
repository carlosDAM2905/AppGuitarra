package com.example.appguitarra.ui.teoria

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.appguitarra.R
import com.example.appguitarra.navigation.Rutas
import com.example.appguitarra.ui.componenteteoria.ListaVideos

@Composable
fun TeoriaModosGriegos(navController: NavController) {
    val guardarEstadoScroll = rememberSaveable(saver = ScrollState.Saver) { ScrollState(0) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(guardarEstadoScroll)
            .padding(
                top = WindowInsets.statusBars.asPaddingValues().calculateTopPadding() + 16.dp, // añadimos 16.dp para que no quede tan pegado a la barra de notificaciones del movil
                start = 32.dp,
                end = 32.dp,
                ),
        verticalArrangement = Arrangement.Top
    ) {

        Text(
            text = stringResource(R.string.modos_griegos),
            color = Color(0xFF5FA3E7),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp)
        )

        Text(
            text = stringResource(R.string.explicacion1_modos_griegos),
            fontSize = 16.sp,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .fillMaxWidth()

        )

        // imagen 1:
        Image(
            painter = painterResource(id = R.drawable.modos_griegos_escalas),
            contentDescription = stringResource(R.string.descripcion_imagen_escalas),
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 660.dp)
                .padding(bottom = 24.dp)
        )

        Text(
            text = stringResource(R.string.modo_jonico_grado1),
            color = Color.Black,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)

        )
        Text(
            text = stringResource(R.string.explicacion_modos_griegos2),
            textAlign = TextAlign.Justify,
            fontSize = 15.sp,
            modifier = Modifier.padding(top = 24.dp, bottom = 32.dp)
        )

        Image(
            painter = painterResource(R.drawable.armadura_mejorada),
            contentDescription = stringResource(R.string.descripcion_armadura_modos_griegos),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        Text(
            text = stringResource(R.string.acordes_en_do_mayor),
            color = Color.Black,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 16.dp)
        )

        Text(
            text = stringResource(R.string.explicacion_modos_griegos3),
            textAlign = TextAlign.Justify,
            fontSize = 15.sp,
            modifier = Modifier
                .padding(top = 16.dp, bottom = 16.dp)
        )

        Image(
            painter = painterResource(R.drawable.armonizada_acordes_tetrada1),
            contentDescription = stringResource(R.string.descripcion_armonizacion_acordes),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp)
        )

        //imagen acordes tetradas y su explicación

        Text(
            stringResource(R.string.modos_griegos_mastil),
            color = Color.Black,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 16.dp)

        )
        Text(
            text = stringResource(R.string.explicacion_modos_griegos4),
            textAlign = TextAlign.Justify,
            fontSize = 15.sp,
            modifier = Modifier
                .padding(bottom = 16.dp)
        )

        Image(
            painter = painterResource(R.drawable.armonizada_acordes_tetrada2),
            contentDescription = stringResource(R.string.descripcion_modos_diapason),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp)
        )

        //modificada la altura para poder visualizar los dos botones
        Spacer(modifier = Modifier.height(64.dp))


        ListaVideos(
            tituloSeccion = "Demostraciones prácticas (modo jónico y patrones en el mástil)",
            videos = listOf(
                "zLiZuwYPpQY" to "1. Modo jónico en mástil (posición 1)",
                "GAsBvKCNiKM" to "2. Patrón escala DO mayor - modo jónico",
                "o_FgJf8dqJU" to "3. Posición grado uno - patrón jónico",
                "maWeOdPSONs" to "4. Modo jónico completo - mástil"
            )
        )

        Spacer(modifier = Modifier.height(64.dp))

        // Botón para actividad
        Button(
            onClick = { navController.navigate(Rutas.MODOS_GRIEGOS_ACTIVIDAD) },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
        ) {
            Text(
                stringResource(R.string.ir_a_actividad)
            )
        }

        HorizontalDivider(
            modifier = Modifier
                .padding(vertical = 16.dp)
                .fillMaxWidth(),
            thickness = 1.dp,
            color = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f)
        )

        // Botón para volver al inicio
        OutlinedButton(
            onClick = { navController.navigate("principal") },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .padding(bottom = 32.dp)
        ) {
            Text(
                stringResource(R.string.volver_pagina_princial),

            )
        }
    }


}


//previews;

@Composable
fun TeoriaModosGriegosPreviewable() {
    TeoriaModosGriegos(navController = rememberNavController())
}


@Composable
@Preview(showBackground = true, showSystemUi = true)
fun TeoriaModosGriegosPreview() {
    TeoriaModosGriegosPreviewable()
}