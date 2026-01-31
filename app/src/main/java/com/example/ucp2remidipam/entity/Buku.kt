package com.example.remedialucp2.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ForeignKey

@Entity(
    tableName = "buku",
    foreignKeys = [
        ForeignKey(
            entity = Kategori::class,
            parentColumns = ["id"],
            childColumns = ["idKategori"],
            onDelete = ForeignKey.SET_NULL
        )
    ]
)
data class Buku(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val judul: String,
    val deskripsi: String,
    val idKategori: Int?,
    val status: String,

    val isDeleted: Boolean = false
)