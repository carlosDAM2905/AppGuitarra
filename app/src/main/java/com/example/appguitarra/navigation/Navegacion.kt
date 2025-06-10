package com.example.appguitarra.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appguitarra.ui.actividades.PantallaActividadArmadura
import com.example.appguitarra.ui.login.PantallaLogin
import com.example.appguitarra.ui.login.PantallaRegistro
import com.example.appguitarra.ui.principal.PantallaPrincipal
import com.example.appguitarra.ui.theme.AppGuitarraTheme


object Rutas {
    const val LOGIN = "login"
    const val PRINCIPAL = "principal"
    const val REGISTRO = "registro"
}

@Composable
fun Navegacion(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Rutas.LOGIN) {

        composable(Rutas.LOGIN) {
            PantallaLogin(
                onLoginSuccess = { navController.navigate(Rutas.PRINCIPAL) },
                onRegistroClick = { /* futura pantalla de registro */ }
            )
        }

        composable(Rutas.REGISTRO) {
            PantallaRegistro(
                onRegistroExitoso = { navController.navigate(Rutas.LOGIN) }
            )
        }


        composable(Rutas.PRINCIPAL) {
            PantallaPrincipal(navController) // ✅ esto está bien
        }

        composable("actividad_armadura") {
            PantallaActividadArmadura(navController)
        }

        }

    }
