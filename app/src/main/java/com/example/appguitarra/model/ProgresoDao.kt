package com.example.appguitarra.model

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
interface ProgresoDao {
    @Insert
    suspend fun insertar(progreso: Progreso)

    @Query("SELECT * FROM progreso WHERE idUsuario = :usuarioId")
    suspend fun obtenerPorUsuario(usuarioId: Int): List<Progreso>
}
