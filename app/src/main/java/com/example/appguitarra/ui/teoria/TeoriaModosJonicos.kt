package com.example.appguitarra.ui.teoria

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.min
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.appguitarra.R
import com.example.appguitarra.navigation.Rutas


@Composable
fun TeoriaModosJonicos(navController: NavController) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(18.dp),
        verticalArrangement = Arrangement.Top
    ) {

        Text(
            text = stringResource(R.string.modos_jonicos),
            color = Color(0xFF5FA3E7),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 16.dp)

        )

        Text(
            text = stringResource(R.string.escala_jonica),
            color = Color.Black,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 12.dp)
        )

        Text(
            text = stringResource(R.string.texto1_modos_jonicos),
            fontSize = 16.sp,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(bottom = 16.dp)
        )

        //imagen 1 jonica

        Image(
            painterResource(id = R.drawable.modo_jonico1),
            contentDescription = stringResource(R.string.descripcion_imagen_griegos1),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp)
        )

        Text(
            text = stringResource(R.string.raiz_bordon),
            color = Color.Black,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 12.dp)
        )

        Text(
            text = stringResource(R.string.explicacion_raiz_bordon),
            fontSize = 16.sp,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(bottom = 16.dp)
        )
        Image(
            painterResource(id = R.drawable.acordes_jonicos_raiz_bordon),
            contentDescription = stringResource(R.string.descripcion_imagen_acordes_jonicos_raiz_bordon),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp)
        )

        Text(
            text = stringResource(R.string.acordes_jonicos_raiz_quinta),
            color = Color.Black,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 12.dp)
        )
        Text(
            text = stringResource(R.string.explicacion_raiz_quinta),
            fontSize = 16.sp,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(bottom = 16.dp)
        )
        Image(
            painterResource(id = R.drawable.acordes_jonicos_raiz_quinta),
            contentDescription = stringResource(R.string.descripcion_imagen_acordes_raiz_en_quinta),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp)
        )

        Text(
            text = stringResource(R.string.acordes_jonicos_raiz_cuarta),
            color = Color.Black,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 12.dp)
        )

        Text(
            text = stringResource(R.string.explicacion_raiz_cuarta),
            fontSize = 16.sp,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(bottom = 16.dp)
        )
        Image(
            painterResource(R.drawable.acordes_jonicos_raiz_cuarta),
            contentDescription = stringResource(R.string.descripcion_imagen_acordes_raiz_en_cuarta),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        Spacer(modifier = Modifier.height(64.dp))

        //botón de actividad:
        Button(
            onClick = { navController.navigate(Rutas.MODOS_JONICOS_ACTIVIDAD) },
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

        //volver a inicio:
        OutlinedButton(
            onClick = { navController.navigate("principal") },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
        ) {
            Text(
                stringResource(R.string.volver_pagina_princial)
            )
        }

    }


}


//previews;

@Composable
fun TeoriaModosJonicosPreviewable() {
    TeoriaModosJonicos(navController = rememberNavController())
}


@Composable
@Preview(showBackground = true, showSystemUi = true)
fun TeoriaModosJonicosPreview() {
    TeoriaModosJonicosPreviewable()
}
