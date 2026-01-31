package com.example.ucp2remidipam.view.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.ucp2remidipam.data.entity.Buku
import com.example.ucp2remidipam.repository.RepositoryPerpus

class EntryViewModel(private val repositoryPerpus: RepositoryPerpus) : ViewModel() {

    var uiStateBuku by mutableStateOf(UiStateBuku())
        private set

    // Update state saat user ngetik
    fun updateUiState(detailBuku: DetailBuku) {
        uiStateBuku = UiStateBuku(detailBuku = detailBuku, isEntryValid = validasiInput(detailBuku))
    }

    private fun validasiInput(uiState: DetailBuku = uiStateBuku.detailBuku): Boolean {
        return uiState.judul.isNotBlank() && uiState.deskripsi.isNotBlank() && uiState.status.isNotBlank()
    }

    suspend fun saveBuku() {
        if (validasiInput()) {
            repositoryPerpus.insertBuku(uiStateBuku.detailBuku.toEntity())
        }
    }
}

data class UiStateBuku(
    val detailBuku: DetailBuku = DetailBuku(),
    val isEntryValid: Boolean = false
)

data class DetailBuku(
    val id: Int = 0,
    val judul: String = "",
    val deskripsi: String = "",
    val status: String = "Tersedia",
    val idKategori: String = ""
)

fun DetailBuku.toEntity(): Buku = Buku(
    id = id,
    judul = judul,
    deskripsi = deskripsi,
    status = status,
    idKategori = idKategori.toIntOrNull(),
    isDeleted = false
)