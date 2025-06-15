package com.example.appguitarra.ui.componenteteoria

import android.content.Intent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appguitarra.ui.teoria.videos.PantallaCompletaVideo


@Composable
fun ListaVideos(tituloSeccion: String, videos: List<Pair<String, String>>) {
    val context = LocalContext.current

    Text(
        text = tituloSeccion,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
        modifier = Modifier.padding(vertical = 8.dp)
    )

    videos.forEach { (videoId, titulo) ->
        Button(
            onClick = {
                val intent = Intent(context, PantallaCompletaVideo::class.java)
                intent.putExtra("videoId", videoId)
                context.startActivity(intent)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 6.dp)
        ) {
            Text(titulo)
        }
    }
}
