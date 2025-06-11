package com.example.appguitarra.ui.teoria

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.appguitarra.R
import com.example.appguitarra.navigation.Rutas
import com.example.appguitarra.ui.theme.AppGuitarraTheme

@Composable
fun TeoriaArmadura(navController: NavController) {

    val scrollState = rememberScrollState()
    Column (
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(18.dp),
        verticalArrangement = Arrangement.Top
    ) {

        Text(
            text = "Armadura armónica",
            fontSize = 24.sp,
            modifier = Modifier
                .padding(top = 16.dp, bottom = 16.dp)
        )
        Text(
            text = "Ciclo de quintas",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 12.dp)

        )

        Text(
            text = "El ciclo de quintas nos muestra cuántos sostenidos tiene cada armadura. Para saber en qué tonalidad Jónica (mayor) está escrita una pieza, se puede observar cuántos sostenidos aparecen y consultarlo en el siguiente gráfico.",
            fontSize = 16.sp,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.ciclo_de_quintas1),
            contentDescription = "Ciclo de quintas 1",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.ciclo_de_quintas2),
            contentDescription = "ciclo de quintas 2",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp)
        )

        Text(
            text = "En caso de que la tonalidad use bemoles en lugar de sostenidos, podemos guiarnos por este otro gráfico:",
            fontSize = 16.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )



        Image(
            painter = painterResource(id = R.drawable.ciclo_de_cuartas),
            contentDescription = "imagen armadura ciclo de cuartas",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Botón para actividad
        Button(
            onClick = { navController.navigate("actividad_armadura") },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
        ) {
            Text("Ir a la actividad")
        }

        // Divider entre botones
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
        ) {
            Text("Volver a la página principal")
        }
    }
}


@Composable
@Preview(showBackground = true, showSystemUi = true)
fun TeoriaArmaduraPreview() {
    val dummyNavController = rememberNavController()
    AppGuitarraTheme {
        TeoriaArmadura(navController = dummyNavController)
    }
}