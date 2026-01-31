package com.example.ucp2remidipam.repository

import com.example.ucp2remidipam.data.PerpusDao
import com.example.ucp2remidipam.data.entity.Buku
import com.example.ucp2remidipam.data.entity.Kategori
import com.example.ucp2remidipam.data.entity.Pengarang
import kotlinx.coroutines.flow.Flow

class LocalRepositoryPerpus(
    private val perpusDao: PerpusDao
) : RepositoryPerpus {

    override suspend fun insertKategori(kategori: Kategori) {
        perpusDao.insertKategori(kategori)
    }

    override fun getAllKategori(): Flow<List<Kategori>> {
        return perpusDao.getAllKategori()
    }

    override suspend fun insertBuku(buku: Buku) {
        perpusDao.insertBuku(buku)
    }

    override fun getAllBuku(): Flow<List<Buku>> {
        return perpusDao.getAllBuku()
    }

    override fun getBuku(id: Int): Flow<Buku> {
        return perpusDao.getBuku(id)
    }

    override suspend fun updateBuku(buku: Buku) {
        perpusDao.updateBuku(buku)
    }

    override suspend fun deleteBuku(buku: Buku) {
        perpusDao.deleteBukuSoft(buku.id)
    }

    override suspend fun insertPengarang(pengarang: Pengarang) {
        perpusDao.insertPengarang(pengarang)
    }

    override fun getAllPengarang(): Flow<List<Pengarang>> {
        return perpusDao.getAllPengarang()
    }
}