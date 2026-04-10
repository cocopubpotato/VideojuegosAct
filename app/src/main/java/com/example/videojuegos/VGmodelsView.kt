package com.example.videojuegos

class VGmodelsView {
    fun getProducts(): List<VGmodels> { //videojuegos
        val prodlist = mutableListOf<VGmodels>()
        prodlist.add(
            VGmodels(nombre = "Metroid Prime Beyond", imagen = R.drawable.mp4, precio = 69.99f, consola = "Switch2", clasif = "T"))
        prodlist.add(VGmodels(nombre = "Mario Kart World", imagen = R.drawable.mkw, precio = 79.99f, consola = "Switch2", clasif = "E"))
        prodlist.add(VGmodels(nombre = "Kirby Air Riders", imagen = R.drawable.kar, precio = 49.9f, consola = "Switch2", clasif = "E"))
        prodlist.add(VGmodels(nombre = "Pokopia", imagen = R.drawable.pkp, precio = 69.9f, consola = "Switch2", clasif = "E"))
        prodlist.add(VGmodels(nombre = "Tomodachi Life: Living The Dream", imagen = R.drawable.tlltd, precio = 59.9f, consola = "Switch2", clasif = "E"))
        prodlist.add(VGmodels(nombre = "StarFox64", imagen = R.drawable.starfox64, precio = 49.9f, consola = "Nintendo 64", clasif = "E"))
        prodlist.add(VGmodels(nombre = "Resident Evil 4", imagen = R.drawable.re4, precio = 39.9f, consola = "Gamecube", clasif = "M"))
        prodlist.add(VGmodels(nombre = "Legend of Zelda: Majora's Mask", imagen = R.drawable.mm, precio = 49.9f, consola = "Nintendo 64", clasif = "E"))
        prodlist.add(VGmodels(nombre = "Transformers War For Cybertron", imagen = R.drawable.tfwfc, precio = 29.9f, consola = "XBOX 360", clasif = "T"))
        prodlist.add(VGmodels(nombre = "Resident Evil 2: Remake", imagen = R.drawable.re2re, precio = 39.9f, consola = "PS4", clasif = "M"))
        prodlist.add(VGmodels(nombre = "deltarune", imagen = R.drawable.deltarune, precio = 19.9f, consola = "Switch2", clasif = "T"))
        return prodlist
    }
}