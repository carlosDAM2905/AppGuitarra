package com.example.appguitarra.model

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.appguitarra.ui.principal.PantallaPrincipal
import com.example.appguitarra.ui.theme.AppGuitarraTheme


data class NotaVisual(
    val texto: String,
    val cuerda: Int,
    val yLine: Float,
    val offsetX: Float? = null // por defecto es 0, pero puedes ajustar
)


val notasExactas = listOf(

    NotaVisual("E", 1, -0.19f, offsetX = -0.55f), NotaVisual("A",2,-0.19f, offsetX = -0.21f),NotaVisual("D",3,-0.19f, offsetX = 0.16f), NotaVisual("G",4,-0.19f, offsetX = 0.51f), NotaVisual("B",5,-0.19f, offsetX = 0.89f), NotaVisual("E",6,-0.19f, offsetX = 1.26f),

    NotaVisual("F", 1,0.05f, offsetX = -0.55f), NotaVisual("B",2,0.43f, offsetX = -0.21f),NotaVisual("E",3,0.43f, offsetX = 0.16f), NotaVisual("A",4,0.43f, offsetX = 0.51f), NotaVisual("C",5,0.05f, offsetX = 0.89f), NotaVisual("F",  6,0.05f,  offsetX = 1.26f),

    NotaVisual("G", 1,0.80f, offsetX = -0.55f), NotaVisual("C",2,0.80f, offsetX = -0.21f),NotaVisual("F",3,0.80f, offsetX = 0.16f), NotaVisual("B",4,1.15f, offsetX = 0.51f), NotaVisual("D",5,0.80f, offsetX = 0.89f), NotaVisual("G",  6,0.80f,  offsetX = 1.26f),

    NotaVisual("A", 1,1.50f, offsetX = -0.55f), NotaVisual("D",2,1.50f, offsetX = -0.21f),NotaVisual("G",3,1.50f, offsetX = 0.16f), NotaVisual("C",4,1.50f, offsetX = 0.51f), NotaVisual("E",5,1.50f, offsetX = 0.89f), NotaVisual("A",  6,1.50f,  offsetX = 1.26f),

    NotaVisual("F", 5,1.88f, offsetX = 0.89f),

    NotaVisual("B", 1,2.22f, offsetX = -0.55f), NotaVisual("E",2,2.22f, offsetX = -0.21f),NotaVisual("A",3,2.22f, offsetX = 0.16f), NotaVisual("D",4,2.22f, offsetX = 0.51f),  NotaVisual("B",  6,2.22f,  offsetX = 1.26f),

    NotaVisual("C", 1,2.60f, offsetX = -0.55f), NotaVisual("F",2,2.60f, offsetX = -0.21f), NotaVisual("G",5,2.60f, offsetX = 0.89f), NotaVisual("C",  6,2.60f,  offsetX = 1.26f),

    NotaVisual("B",3,2.98f, offsetX = 0.16f), NotaVisual("E",4,2.98f, offsetX = 0.51f),

    NotaVisual("D", 1,3.35f, offsetX = -0.55f), NotaVisual("G",2,3.35f, offsetX = -0.21f),NotaVisual("C",3,3.35f, offsetX = 0.16f), NotaVisual("F",4,3.35f, offsetX = 0.51f), NotaVisual("A",5,3.35f, offsetX = 0.89f), NotaVisual("D",  6,3.35f,  offsetX = 1.26f),

    NotaVisual("E", 1,4.05f, offsetX = -0.55f), NotaVisual("A",2,4.05f, offsetX = -0.21f),NotaVisual("D",3,4.05f, offsetX = 0.16f), NotaVisual("G",4,4.05f, offsetX = 0.51f), NotaVisual("B",5,4.05f, offsetX = 0.89f), NotaVisual("E",  6,4.05f,  offsetX = 1.26f),

    NotaVisual("F", 1,4.40f, offsetX = -0.55f),  NotaVisual("C",5,4.40f, offsetX = 0.89f), NotaVisual("F",  6,4.40f,  offsetX = 1.26f),

    NotaVisual("B",2,4.76f, offsetX = -0.21f),NotaVisual("E",3,4.76f, offsetX = 0.16f), NotaVisual("A",4,4.76f, offsetX = 0.51f), NotaVisual("I",  6,4.76f,  offsetX = 1.26f),

    NotaVisual("G", 1,5.12f, offsetX = -0.55f), NotaVisual("C",2,5.12f, offsetX = -0.21f),NotaVisual("F",3,5.12f, offsetX = 0.16f), NotaVisual("D",5,5.12f, offsetX = 0.89f), NotaVisual("E",  6,5.12f,  offsetX = 1.26f),

    NotaVisual("B",4,5.48f, offsetX = 0.51f),

    NotaVisual("A", 1, 5.84f, offsetX = -0.55f), NotaVisual("D",2,5.84f, offsetX = -0.21f),NotaVisual("G",3,5.84f, offsetX = 0.16f), NotaVisual("C",4,5.84f, offsetX = 0.51f), NotaVisual("E",5,5.84f, offsetX = 0.89f), NotaVisual("A",6,5.84f, offsetX = 1.26f),

    NotaVisual("G", 1,5.12f, offsetX = -0.55f), NotaVisual("C",2,5.12f, offsetX = -0.21f),NotaVisual("F",3,5.12f, offsetX = 0.16f), NotaVisual("D",5,5.12f, offsetX = 0.89f), NotaVisual("E",  6,5.12f,  offsetX = 1.26f),

    NotaVisual("B",4,5.48f, offsetX = 0.51f),

    NotaVisual("A", 1, 5.84f, offsetX = -0.55f), NotaVisual("D",2,5.84f, offsetX = -0.21f),NotaVisual("G",3,5.84f, offsetX = 0.16f), NotaVisual("C",4,5.84f, offsetX = 0.51f), NotaVisual("E",5,5.84f, offsetX = 0.89f), NotaVisual("A",6,5.84f, offsetX = 1.26f),

    NotaVisual("F",5,6.22f, offsetX = 0.89f),

    NotaVisual("B", 1, 6.60f, offsetX = -0.55f), NotaVisual("E", 2, 6.60f, offsetX = -0.21f), NotaVisual("A", 3, 6.60f, offsetX = 0.16f), NotaVisual("D", 4, 6.60f, offsetX = 0.51f), NotaVisual("B", 6, 6.60f, offsetX = 1.26f),

    NotaVisual("C", 1, 6.95f, offsetX = -0.55f), NotaVisual("F", 2, 6.95f, -0.21f), NotaVisual("G", 5, 6.95f, offsetX = 0.89f), NotaVisual("C", 6, 6.95f, offsetX = 1.26f),

    NotaVisual("B", 3, 7.32f, offsetX = 0.16f), NotaVisual("E", 4, 7.32f, 0.51f),

    NotaVisual("D", 1, 7.68f, offsetX = -0.55f), NotaVisual("G", 2, 7.68f, offsetX = -0.21f), NotaVisual("C", 3, 7.68f, offsetX = 0.16f), NotaVisual("P", 4, 7.68f, offsetX = 0.51f), NotaVisual("A", 5, 7.68f, offsetX = 0.89f), NotaVisual("D", 6, 7.68f, offsetX = 1.26f),

    )

@Preview(showBackground = true)
@Composable
fun PreviewPantallaPrincipal() {
    AppGuitarraTheme {
        PantallaPrincipal()
    }
}


