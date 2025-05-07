package com.example.appguitarra.ui.login

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.appguitarra.data.AppDatabase
import com.example.appguitarra.model.Usuario
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun PantallaRegistro(
    onRegistroExitoso: () -> Unit
) {
    val contexto = LocalContext.current
    val db = remember { AppDatabase.getDatabase(contexto) }
    val scope = rememberCoroutineScope()

    var nombre by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var contraseña by remember { mutableStateOf("") }
    var mensajeError by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text("Registro", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Correo electrónico") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = contraseña,
            onValueChange = { contraseña = it },
            label = { Text("Contraseña") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (nombre.isBlank() || email.isBlank() || contraseña.isBlank()) {
                    mensajeError = "Rellena todos los campos"
                } else {
                    scope.launch(Dispatchers.IO) {
                        val usuarioExistente = db.usuarioDao().obtenerPorEmail(email)
                        if (usuarioExistente != null) {
                            mensajeError = "Ya existe un usuario con este email"
                        } else {
                            db.usuarioDao().insertar(
                                Usuario(
                                    nombre = nombre,
                                    email = email,
                                    contraseña = contraseña,
                                    esPremium = false
                                )
                            )
                            onRegistroExitoso()
                        }
                    }
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Registrarse")
        }

        if (mensajeError.isNotBlank()) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(mensajeError, color = MaterialTheme.colorScheme.error)
        }
    }
}
