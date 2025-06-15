package com.example.appguitarra.ui.login

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.appguitarra.R
import com.example.appguitarra.data.AppDatabase
import com.example.appguitarra.model.Usuario
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Composable
fun PantallaRegistro(
    navController: NavController,
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
            .verticalScroll(rememberScrollState())
            .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            stringResource(R.string.titulo_registro),
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text(stringResource(R.string.nombre_usuario)) },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text(stringResource(R.string.correo_electronico)) },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = contraseña,
            onValueChange = { contraseña = it },
            label = { Text(stringResource(R.string.contraseña)) },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                when {
                    nombre.isBlank() || email.isBlank() || contraseña.isBlank() -> {
                        mensajeError = contexto.getString(R.string.error_campos_vacios)
                    }

                    !esEmailValido(email) -> {
                        mensajeError = "Introduce un correo válido"
                    }

                    !esContraseñaValida(contraseña) -> {
                        mensajeError = "La contraseña debe tener mínimo 8 caracteres, una mayúscula, una minúscula y un número"
                    }

                    else -> {
                        scope.launch(Dispatchers.IO) {
                            val usuarioExistente = db.usuarioDao().obtenerPorEmail(email)
                            if (usuarioExistente != null) {
                                mensajeError = contexto.getString(R.string.error_usuario_existente)
                            } else {
                                db.usuarioDao().insertar(
                                    Usuario(
                                        nombre = nombre,
                                        email = email,
                                        contraseña = contraseña,
                                        esPremium = false
                                    )
                                )
                                withContext(Dispatchers.Main) {
                                    onRegistroExitoso()
                                }
                            }
                        }
                    }
                }
            },


                    modifier = Modifier.fillMaxWidth()
        ) {
            Text(stringResource(R.string.boton_registrarse))
        }

        Button(
            onClick = {
                navController.popBackStack()
            },
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth()
        ) {
            Text(stringResource(R.string.boton_volver_login))


        }


        if (mensajeError.isNotBlank()) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(mensajeError, color = MaterialTheme.colorScheme.error)
        }
    }
}
