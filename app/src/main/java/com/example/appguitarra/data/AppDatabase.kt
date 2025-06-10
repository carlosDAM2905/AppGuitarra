package com.example.appguitarra.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.appguitarra.model.Usuario
import com.example.appguitarra.model.UsuarioDao


@Database(entities = [Usuario::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun usuarioDao(): UsuarioDao
    /*abstract fun progresoDao(): ProgresoDao
    abstract fun contenidoDao(): ContenidoDao*/

    companion object {
        @Volatile private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "appguitarra_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}