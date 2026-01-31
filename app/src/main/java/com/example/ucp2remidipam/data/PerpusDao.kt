package com.example.ucp2remidipam.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.ucp2remidipam.data.entity.Buku
import com.example.ucp2remidipam.data.entity.Kategori
import com.example.ucp2remidipam.data.entity.Pengarang
import kotlinx.coroutines.flow.Flow

@Dao
interface PerpusDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertKategori(kategori: Kategori)

    @Query("SELECT * FROM kategori ORDER BY nama ASC")
    fun getAllKategori(): Flow<List<Kategori>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertBuku(buku: Buku)

    @Query("SELECT * FROM buku WHERE isDeleted = 0 ORDER BY judul ASC")
    fun getAllBuku(): Flow<List<Buku>>

    @Query("SELECT * FROM buku WHERE id = :id")
    fun getBuku(id: Int): Flow<Buku>

    @Update
    suspend fun updateBuku(buku: Buku)

    @Query("UPDATE buku SET isDeleted = 1 WHERE id = :idBuku")
    suspend fun deleteBukuSoft(idBuku: Int)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertPengarang(pengarang: Pengarang)

    @Query("SELECT * FROM pengarang ORDER BY nama ASC")
    fun getAllPengarang(): Flow<List<Pengarang>>
}