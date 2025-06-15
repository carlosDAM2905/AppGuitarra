package com.example.appguitarra.model

import androidx.room.*
import com.example.appguitarra.model.Usuario


/**
 * Interfaz DAO para acceder y gestionar los datos de usuarios en la base de datos local Room.
 */
@Dao
interface UsuarioDao {

    /**
     * -Inserta un nuevo usuario en la base de datos.
     * -Si el usuario ya existe (por email), lo reemplaza
     * -Se suele usar en el registro de usuarios.
     * */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(usuario: Usuario)




    /**
     * -Realiza una consulta de inicio de sesión.
     * -Busca un usuario que tenga ese email y esa contraseña.
     * -Si lo encuentra, devuelve el objeto Usuario y si no, devuelve null.
     */
    @Query("SELECT * FROM usuario WHERE LOWER(email) = LOWER(:email) AND contraseña = :contraseña")
    suspend fun login(email: String, contraseña: String): Usuario?





    /**
     * -Busca un usuario por su email.
     * -Se puede usar para comprobar si ya existe antes de registrar uno nuevo.
     */
    @Query("SELECT * FROM usuario WHERE email = :email")
    suspend fun obtenerPorEmail(email: String): Usuario?
}