package com.example.ucp2remidipam.repository

import com.example.ucp2remidipam.data.entity.Buku
import com.example.ucp2remidipam.data.entity.Kategori
import com.example.ucp2remidipam.data.entity.Pengarang
import kotlinx.coroutines.flow.Flow

interface RepositoryPerpus {
    suspend fun insertKategori(kategori: Kategori)
    fun getAllKategori(): Flow<List<Kategori>>
    suspend fun insertBuku(buku: Buku)
    fun getAllBuku(): Flow<List<Buku>>
    fun getBuku(id: Int): Flow<Buku>
    suspend fun updateBuku(buku: Buku)
    suspend fun deleteBuku(buku: Buku)
    suspend fun insertPengarang(pengarang: Pengarang)
    fun getAllPengarang(): Flow<List<Pengarang>>
}