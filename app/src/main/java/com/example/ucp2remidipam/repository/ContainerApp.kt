package com.example.ucp2remidipam.repository

import android.content.Context
import com.example.ucp2remidipam.data.PerpusDatabase

interface AppContainer {
    val repositoryPerpus: RepositoryPerpus
}

class ContainerApp(private val context: Context) : AppContainer {
    override val repositoryPerpus: RepositoryPerpus by lazy {
        LocalRepositoryPerpus(PerpusDatabase.getDatabase(context).perpusDao())
    }
}