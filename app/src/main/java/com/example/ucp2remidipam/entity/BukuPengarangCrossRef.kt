package com.example.ucp2remidipam.data.entity

import androidx.room.Entity
import androidx.room.Index

@Entity(
    tableName = "buku_pengarang_cross_ref",
    primaryKeys = ["bukuId", "pengarangId"],
    indices = [Index(value = ["bukuId"]), Index(value = ["pengarangId"])]
)
data class BukuPengarangCrossRef(
    val bukuId: Int,
    val pengarangId: Int
)