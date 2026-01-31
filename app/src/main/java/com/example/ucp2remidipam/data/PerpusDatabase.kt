package com.example.ucp2remidipam.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.ucp2remidipam.data.entity.Buku
import com.example.ucp2remidipam.data.entity.BukuPengarangCrossRef
import com.example.ucp2remidipam.data.entity.Kategori
import com.example.ucp2remidipam.data.entity.Pengarang

@Database(
    entities = [
        Buku::class,
        Kategori::class,
        Pengarang::class,
        BukuPengarangCrossRef::class
    ],
    version = 1,
    exportSchema = false
)
abstract class PerpusDatabase : RoomDatabase() {

    abstract fun perpusDao(): PerpusDao

    companion object {
        @Volatile
        private var Instance: PerpusDatabase? = null

        fun getDatabase(context: Context): PerpusDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    PerpusDatabase::class.java,
                    "perpustakaan_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { Instance = it }
            }
        }
    }
}