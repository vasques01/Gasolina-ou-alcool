package com.example.filip.gasolinaoualcool


interface MainView {

    fun showLoading()

    fun hideLoading()

    fun showResult(stringId: Int)

    fun onError(stringId: Int)
}