package com.example.ucp2remidipam.view.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ucp2remidipam.view.halaman.HalamanEntry
import com.example.ucp2remidipam.view.halaman.HalamanHome

@Composable
fun PengelolaHalaman(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route,
        modifier = Modifier
    ) {
        composable(route = DestinasiHome.route) {
            HalamanHome(
                navigateToItemEntry = {
                    navController.navigate(DestinasiEntry.route)
                }
            )
        }

        composable(route = DestinasiEntry.route) {
            HalamanEntry(
                navigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}