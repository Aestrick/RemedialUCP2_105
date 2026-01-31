package com.example.ucp2remidipam.view.navigation

interface DestinasiNavigasi {
    val route: String
    val titleRes: String
}

object DestinasiHome : DestinasiNavigasi {
    override val route = "home"
    override val titleRes = "Home"
}

object DestinasiEntry : DestinasiNavigasi {
    override val route = "entry"
    override val titleRes = "Entry Buku"
}

object DestinasiDetail : DestinasiNavigasi {
    override val route = "detail"
    override val titleRes = "Detail Buku"
    const val idBuku = "idBuku"
    val routeWithArgs = "$route/{$idBuku}"
}

object DestinasiUpdate : DestinasiNavigasi {
    override val route = "update"
    override val titleRes = "Edit Buku"
    const val idBuku = "idBuku"
    val routeWithArgs = "$route/{$idBuku}"
}