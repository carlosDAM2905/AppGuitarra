package com.example.appguitarra.navigation

import PantallaLogin
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import com.example.appguitarra.ui.actividades.PantallaActividadArmadura
import com.example.appguitarra.ui.actividades.PantallaActividadModosGriegos
import com.example.appguitarra.ui.actividades.PantallaActividadModosJonicos
import com.example.appguitarra.ui.login.PantallaRegistro
import com.example.appguitarra.ui.principal.PantallaPrincipal
import com.example.appguitarra.ui.teoria.TeoriaArmadura
import com.example.appguitarra.ui.teoria.TeoriaModosGriegos
import com.example.appguitarra.ui.teoria.TeoriaModosJonicos


object Rutas {
    const val LOGIN = "login"
    const val PRINCIPAL = "principal"
    const val REGISTRO = "registro"

    //armadura
    const val TEORIA_ARMADURA = "armadura"
    const val ARMADURA_ACTIVIDAD = "actividad_armadura"

    //modos griegos
    const val TEORIA_MODOS_GRIEGOS = "griegos"
    const val MODOS_GRIEGOS_ACTIVIDAD = "actividad_modos_griegos"

    //modos jonicos
    const val TEORIA_MODOS_JONICOS = "jonicos"
    const val MODOS_JONICOS_ACTIVIDAD = "actividad_modos_jonicos"
}

@Composable
fun Navegacion(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Rutas.LOGIN) {

        composable(Rutas.LOGIN) {
            PantallaLogin(
                onLoginSuccess = { navController.navigate(Rutas.PRINCIPAL) },
                onRegistroClick = { navController.navigate(Rutas.REGISTRO) }
            )
        }

        composable(Rutas.REGISTRO) {
            PantallaRegistro(
                navController = navController,
                onRegistroExitoso = { navController.navigate(Rutas.LOGIN) }
            )
        }


        composable(Rutas.PRINCIPAL) {
            PantallaPrincipal(navController)
        }

        //rev
        composable("actividad_armadura") {
            PantallaActividadArmadura(navController)
        }

        composable(Rutas.TEORIA_ARMADURA) {
            TeoriaArmadura(
                navController
            )
        }

        composable(Rutas.ARMADURA_ACTIVIDAD) {
            PantallaActividadArmadura(
                navController
            )
        }

        composable(Rutas.TEORIA_MODOS_GRIEGOS) {
            TeoriaModosGriegos(
                navController
            )
        }

        composable(Rutas.MODOS_GRIEGOS_ACTIVIDAD) {
            PantallaActividadModosGriegos(
                navController
            )
        }

        composable(Rutas.TEORIA_MODOS_JONICOS) {
            TeoriaModosJonicos(
                navController
            )
        }

        composable(Rutas.MODOS_JONICOS_ACTIVIDAD) {
            PantallaActividadModosJonicos(
                navController
            )

        }



        }

    }
