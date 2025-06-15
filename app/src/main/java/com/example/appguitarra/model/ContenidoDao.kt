package com.example.appguitarra.model


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

/**
 * Interfaz DAO para acceder a la tabla de contenido de la base de datos.
 * Permite insertar, actualizar y consultar contenidos educativos (actividades, lecciones, etc).
 */
@Dao
interface ContenidoDao {


    /**
     * Inserta una lista completa de contenidos.
     * Se usa al iniciar la app o cargar datos iniciales
     */
    @Insert
    suspend fun insertarTodo(lista: List<Contenido>)

    /*Inserta un único contenido en la base de datos, util si solo quieres añadir uno nuevo*/
    @Insert
    suspend fun insertar(contenido: Contenido)

    /* Actualiza un contenido ya existente, se usa si hay cambios en un contenido ya guardado*/
    @Update
    suspend fun actualizar(contenido: Contenido)

    /*
      Devuelve todos los contenidos que no son premium, cuando se implemente la opción premium (premium = 0)
     */
    @Query("SELECT * FROM contenido WHERE premium = 0")
    suspend fun obtenerContenidoGratis(): List<Contenido>

    /*
    Busca un contenido por su ID. Devuelve el contenido si existe o null si no existe:
     */
    @Query("SELECT * FROM contenido WHERE id = :idContenido")
    suspend fun obtenerPorId(idContenido: Int): Contenido?

    /*
      Busca un contenido por su título, útil cuando quieres encontrar un contenido específico por su nombre:
     */
    @Query("SELECT * FROM contenido WHERE titulo = :titulo LIMIT 1")
    suspend fun obtenerPorTitulo(titulo: String): Contenido?

    /*
     Devuelve todos los contenidos de la base de datos:
     */
    @Query("SELECT * FROM contenido")
    suspend fun obtenerTodos(): List<Contenido>

}