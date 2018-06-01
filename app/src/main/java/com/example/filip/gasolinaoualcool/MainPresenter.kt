package com.example.filip.gasolinaoualcool


interface MainPresenter {

    fun estimateBetterChoice(valorAlcool: Double, valorGasolina: Double)

    fun validateFields(textoPrecoAlcool: String, textoPrecoGasolina: String)
}