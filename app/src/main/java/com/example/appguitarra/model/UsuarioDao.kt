package com.example.appguitarra.model

import androidx.room.*
import com.example.appguitarra.model.Usuario

@Dao
interface UsuarioDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(usuario: Usuario)

    @Query("SELECT * FROM usuario WHERE LOWER(email) = LOWER(:email) AND contraseña = :contraseña")
    suspend fun login(email: String, contraseña: String): Usuario?

    @Query("SELECT * FROM usuario WHERE email = :email")
    suspend fun obtenerPorEmail(email: String): Usuario?
}