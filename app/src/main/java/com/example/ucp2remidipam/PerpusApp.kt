package com.example.ucp2remidipam

import android.app.Application
import com.example.ucp2remidipam.repository.AppContainer
import com.example.ucp2remidipam.repository.ContainerApp

class PerpusApp : Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = ContainerApp(this)
    }
}