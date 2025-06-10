package com.example.appguitarra.model


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ContenidoDao {

    @Insert
    suspend fun insertar(contenido: Contenido)

    @Update
    suspend fun actualizar(contenido: Contenido)

    @Query("SELECT * FROM contenido WHERE premium = 0")
    suspend fun obtenerContenidoGratis(): List<Contenido>

    @Query("SELECT * FROM contenido WHERE id = :idContenido")
    suspend fun obtenerPorId(idContenido: Int): Contenido?
}