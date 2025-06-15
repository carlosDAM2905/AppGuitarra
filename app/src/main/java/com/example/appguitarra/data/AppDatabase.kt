package com.example.appguitarra.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.appguitarra.model.*
import com.example.appguitarra.utils.TitulosContenido
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(
    entities = [Usuario::class, Contenido::class, Progreso::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun usuarioDao(): UsuarioDao
    abstract fun progresoDao(): ProgresoDao
    abstract fun contenidoDao(): ContenidoDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "appguitarra_db"
                )
                    .addCallback(object : RoomDatabase.Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)

                        }

                        override fun onOpen(db: SupportSQLiteDatabase) {
                            super.onOpen(db)
                            CoroutineScope(Dispatchers.IO).launch {
                                INSTANCE?.let { dbInstance ->
                                    insertarContenidosSiEsNecesario(dbInstance)
                                }
                            }
                        }
                    })
                    .build()

                INSTANCE = instance
                instance
            }
        }

        private suspend fun insertarContenidosSiEsNecesario(db: AppDatabase) {
            val contenidoDao = db.contenidoDao()
            val contenidos = contenidoDao.obtenerTodos()
            if (contenidos.isEmpty()) {
                contenidoDao.insertarTodo(
                    listOf(
                        Contenido(
                            titulo = TitulosContenido.MODOS_JONICOS,
                            descripcion = "Actividad sobre modos jónicos",
                            tipo = "actividad",
                            url = null,
                            premium = false
                        ),
                        Contenido(
                            titulo = TitulosContenido.ARMADURA_ARMONICA,
                            descripcion = "Actividad sobre armadura",
                            tipo = "actividad",
                            url = null,
                            premium = false
                        ),
                        Contenido(
                            titulo = TitulosContenido.MODOS_GRIEGOS,
                            descripcion = "Actividad sobre modos griegos",
                            tipo = "actividad",
                            url = null,
                            premium = false
                        )
                    )
                )
            }
        }
    }
}
