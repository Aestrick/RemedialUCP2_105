package com.example.ucp2remidipam.view.viewmodel

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.ucp2remidipam.PerpusApp

object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer {
            HomeViewModel(aplikasiPerpus().container.repositoryPerpus)
        }
        initializer {
            EntryViewModel(aplikasiPerpus().container.repositoryPerpus)
        }
    }
}

fun CreationExtras.aplikasiPerpus(): PerpusApp =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as PerpusApp)