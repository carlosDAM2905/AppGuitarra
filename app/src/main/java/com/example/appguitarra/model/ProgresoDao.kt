package com.example.appguitarra.model

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;


/**
 * Interfaz DAO (Data Access Object) para acceder y modificar los registros de progreso
 * del usuario en la base de datos local Room.
 */
@Dao
interface ProgresoDao {

   /* Inserta un nuevo registro de progreso en la base de datos.
    Se utiliza cuando el usuario completa una actividad con éxito.*/

    @Insert
    suspend fun insertar(progreso: Progreso)

    /*
    obtiene el progreso de un usuario y se utiliza para calcular el numero de actividades completadas y mostrarlo en el rosco
     */
    @Query("SELECT * FROM progreso WHERE idUsuario = :usuarioId")
    suspend fun obtenerPorUsuario(usuarioId: Int): List<Progreso>

    /*
    Obtiene el progreso de un usuario para un contenido concreto
     * comprueba si ya ha realizado esa actividad y evita duplicados ya que accede al primer registro LIMIT1.
     */

    @Query("SELECT * FROM progreso WHERE idUsuario = :usuarioId AND idContenido = :contenidoId LIMIT 1")
    suspend fun obtenerProgreso(usuarioId: Int, contenidoId: Int): Progreso?
}
