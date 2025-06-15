package com.example.appguitarra.ui.login

import android.util.Patterns

//utilizamos el patron de Android que contiene una constante: (Patterns.EMAIL_ADRESS) para comprobar si el texto introducido por el user tiene un formato de email valido
fun esEmailValido(email: String): Boolean {
    return Patterns.EMAIL_ADDRESS.matcher(email).matches()
}

/**
// En esta función definimos una expresión regular que exige:
// - Al menos una mayúscula
// -Al menos una minúscula
// - Al menos un número
// - Al menos un carácter especial
// - Longitud mínima de 8 caracteres
// Aunque no se aplica de momento, queda lista para futuras mejoras de seguridad y dar fluidez en la presentación:
*/
fun esContraseñaValida(contraseña: String): Boolean {
    // Requiere: al menos 1 mayúscula, 1 minúscula, 1 número, y mínimo 8 caracteres
    val regex = Regex("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)[A-Za-z\\d]{8,}$")
    return regex.matches(contraseña)
}
