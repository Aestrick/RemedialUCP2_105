package com.example.ucp2remidipam.view.halaman

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ucp2remidipam.view.viewmodel.EntryViewModel
import com.example.ucp2remidipam.view.viewmodel.PenyediaViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanEntry(
    navigateBack: () -> Unit,
    viewModel: EntryViewModel = viewModel(factory = PenyediaViewModel.Factory)
) {
    val coroutineScope = rememberCoroutineScope()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Tambah Buku") },
                navigationIcon = {
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            OutlinedTextField(
                value = viewModel.uiStateBuku.detailBuku.judul,
                onValueChange = { viewModel.updateUiState(viewModel.uiStateBuku.detailBuku.copy(judul = it)) },
                label = { Text("Judul Buku") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = viewModel.uiStateBuku.detailBuku.deskripsi,
                onValueChange = { viewModel.updateUiState(viewModel.uiStateBuku.detailBuku.copy(deskripsi = it)) },
                label = { Text("Deskripsi") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = viewModel.uiStateBuku.detailBuku.status,
                onValueChange = { viewModel.updateUiState(viewModel.uiStateBuku.detailBuku.copy(status = it)) },
                label = { Text("Status (Tersedia/Dipinjam)") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = {
                    coroutineScope.launch {
                        viewModel.saveBuku()
                        navigateBack()
                    }
                },
                enabled = viewModel.uiStateBuku.isEntryValid,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Simpan Buku")
            }
        }
    }
}