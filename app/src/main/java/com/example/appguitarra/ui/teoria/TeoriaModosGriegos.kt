package com.example.appguitarra.ui.teoria

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
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
import androidx.compose.ui.res.painterResource
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
fun TeoriaModosGriegos (navController: NavController) {
    val scrollState = rememberScrollState()
    Column (
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(18.dp),
        verticalArrangement = Arrangement.Top
    ) {

        Text(
            text = "Modos Griegos",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 16.dp)
        )

        Text(
            text = "Los modos griegos son escalas que se forman a partir de las notas de una tonalidad mayor, comenzando desde cada uno de sus grados. Cada modo tiene su propia sonoridad y uso característico en la música moderna y clásica.",
            fontSize = 16.sp,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(bottom = 16.dp)
        )

        // imagen 1 jonica:
        Image(
            painter = painterResource(id = R.drawable.modos_griegos_escalas),
            contentDescription = "Modos griegos - escalas",
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 660.dp)
                .padding(bottom = 24.dp)
        )

        Text(text = "Modo Jónico (I grado)",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold
        )
        Text(
            text = "Cada modo griego tiene una estructura de intervalos propia. En esta imagen se muestra la armadura de cada modo, es decir, las notas que lo componen cuando parten desde su nota característica, manteniéndose dentro de la tonalidad de Do mayor.",
            textAlign = TextAlign.Justify,
            fontSize = 15.sp,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        Image(
            painter = painterResource(R.drawable.armadura_mejorada),
            contentDescription = "Armaduras de los modos griegos",
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )

        Text(
            text = "Una forma habitual de aplicar los modos griegos es armonizar la escala mayor con acordes de séptima (tétradas). Aquí vemos los acordes que corresponden a cada grado de la escala de Do mayor, y cómo cada uno está asociado a un modo.",
            textAlign = TextAlign.Justify,
            fontSize = 15.sp,
            modifier = Modifier
                .padding(bottom = 16.dp)
        )

        Image(
            painter = painterResource(R.drawable.armonizada_acordes_tetrada1),
            contentDescription = "Armonización en acordes de séptima",
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp)
        )

        //imagen acordes tetradas y su explicación
        Text(
            text = "Esta representación en el mástil muestra cómo se distribuyen las notas de cada modo griego en el diapasón. Cada fila corresponde a un modo, y cada columna a una posición en la guitarra, relacionando grados y acordes.",
            textAlign = TextAlign.Justify,
            fontSize = 15.sp,
            modifier = Modifier
                .padding(bottom = 16.dp)
        )

        Image(
            painter = painterResource(R.drawable.armonizada_acordes_tetrada2),
            contentDescription = "Modos en el diapasón de la guitarra",
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp)
        )

        //modificada la altura para poder visualizar los dos botones
        Spacer(modifier = Modifier.height(64.dp))

        // Botón para actividad
        Button(
            onClick = { navController.navigate(Rutas.MODOS_GRIEGOS_ACTIVIDAD) },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
        ) {
            Text("Ir a la actividad")
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
            onClick = { navController.navigate(Rutas.PRINCIPAL) },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
        ) {
            Text("Volver a la página principal")
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