import android.util.Patterns
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appguitarra.R
import com.example.appguitarra.data.AppDatabase
import com.example.appguitarra.data.AppSesion
import com.example.appguitarra.ui.theme.AppGuitarraTheme
import kotlinx.coroutines.*

@Composable
fun PantallaLogin(
    onLoginSuccess: () -> Unit,
    onRegistroClick: () -> Unit
) {
    val contexto = LocalContext.current
    val db = remember { AppDatabase.getDatabase(contexto) }
    val scope = rememberCoroutineScope()



    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var mensajeError by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()) // añadido scroll vertical para no bloquear el login
            .background(Color.White)
            .padding(24.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(24.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_guitarra),
                contentDescription = stringResource(R.string.descripcion_logo_guitarrapp),
                modifier = Modifier
                    .height(60.dp)
                    .padding(end = 12.dp)
            )
            Text(
                stringResource(R.string.nombre_app),
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF153B59)
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Contenedor con sombra para los campos
        Surface(
            shape = RoundedCornerShape(16.dp),
            shadowElevation = 8.dp,
            tonalElevation = 2.dp,
            modifier = Modifier.fillMaxWidth(),
            color = Color.White //modo claro en el login, sino falla
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text(stringResource(R.string.correo_electronico)) },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(),
                    textStyle = TextStyle(color = Color.Black)
                )

                Spacer(modifier = Modifier.height(12.dp))

                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text(stringResource(R.string.contraseña)) },
                    singleLine = true,
                    visualTransformation = PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth(),
                    textStyle = TextStyle(color = Color.Black)
                )

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {
                        if (email.isBlank() || password.isBlank()) {

                            mensajeError = contexto.getString(R.string.error_campos_vacios)


                        } else {
                            scope.launch(Dispatchers.IO) {
                                val usuario = db.usuarioDao().login(email, password)
                                if (usuario != null) {
                                    withContext(Dispatchers.Main) {
                                        AppSesion.usuarioActual = usuario
                                        mensajeError = ""
                                        onLoginSuccess()
                                    }
                                } else {
                                    withContext(Dispatchers.Main) {
                                        mensajeError = contexto.getString(R.string.error_credenciales)
                                    }
                                }
                            }
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(stringResource(R.string.iniciar_sesion))
                }

                if (mensajeError.isNotEmpty()) {
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(mensajeError, color = Color.Red) // fuerza el rojo clásico

                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        TextButton(onClick = onRegistroClick) {
            Text(stringResource(R.string.no_tienes_cuenta))
        }
    }
}

fun esEmailValido(email: String): Boolean {
    return Patterns.EMAIL_ADDRESS.matcher(email).matches()
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewPantallaLogin() {
    AppGuitarraTheme {
        PantallaLogin(
            onLoginSuccess = {},
            onRegistroClick = {}
        )
    }
}
