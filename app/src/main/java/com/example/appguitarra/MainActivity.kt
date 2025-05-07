package com.example.appguitarra

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.appguitarra.navigation.Navegacion
import com.example.appguitarra.ui.principal.PantallaPrincipal
import com.example.appguitarra.ui.theme.AppGuitarraTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppGuitarraTheme {
                val navController = rememberNavController()
                Navegacion(navController)

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewApp() {
    AppGuitarraTheme {
        val navController = rememberNavController()
        Navegacion(navController)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPantallaPrincipal() {
    AppGuitarraTheme {
        PantallaPrincipal()
    }
}





