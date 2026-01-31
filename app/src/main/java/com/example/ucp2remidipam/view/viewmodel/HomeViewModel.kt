package com.example.ucp2remidipam.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ucp2remidipam.data.entity.Buku
import com.example.ucp2remidipam.repository.RepositoryPerpus
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

data class HomeUiState(
    val listBuku: List<Buku> = listOf(),
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String = ""
)

class HomeViewModel(
    private val repositoryPerpus: RepositoryPerpus
) : ViewModel() {

    val homeUiState: StateFlow<HomeUiState> = repositoryPerpus.getAllBuku()
        .filterNotNull()
        .map {
            HomeUiState(
                listBuku = it,
                isLoading = false
            )
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = HomeUiState(isLoading = true)
        )
}