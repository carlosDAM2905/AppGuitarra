package com.example.appguitarra.ui.teoria.videos


import android.os.Bundle
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView
import com.example.appguitarra.R

class PantallaCompletaVideo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val rootLayout = FrameLayout(this).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
        }

        // Crea una Toolbar con botón de volver
        val toolbar = Toolbar(this).apply {
            setNavigationIcon(R.drawable.ic_arrow_background2) // usa un icono en res/drawable
            setNavigationOnClickListener { finish() } // cerrar esta pantalla
            title = "Reproduciendo video"
            setBackgroundColor(0xFF1F1F1F.toInt())
            setTitleTextColor(0xFFFFFFFF.toInt())
            layoutParams = Toolbar.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        }

        val videoId = intent.getStringExtra("videoId") ?: return

        val youTubePlayerView = YouTubePlayerView(this).apply {
            layoutParams = FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
        }

        // Añade ambos elementos al layout
        rootLayout.addView(youTubePlayerView)
        rootLayout.addView(toolbar)

        setContentView(rootLayout)
        lifecycle.addObserver(youTubePlayerView)

        youTubePlayerView.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                youTubePlayer.loadVideo(videoId, 0f)
            }
        })
    }
}
