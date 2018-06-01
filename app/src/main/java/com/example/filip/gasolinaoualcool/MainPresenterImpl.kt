package com.example.filip.gasolinaoualcool


class MainPresenterImpl(val mainView: MainView): MainPresenter {

    override fun estimateBetterChoice(valorAlcool: Double, valorGasolina: Double) {
        mainView.showLoading()
        val resultado = valorAlcool / valorGasolina

        if (resultado >= 0.7) {
            //Gasolina
            mainView.hideLoading()
            mainView.showResult(R.string.better_use_gas)
        } else {
            //Alcool
            mainView.hideLoading()
            mainView.showResult(R.string.better_use_alcohol)
        }
    }

    override fun validateFields(textoPrecoAlcool: String, textoPrecoGasolina: String) {
        if (textoPrecoAlcool == "") {
            mainView.onError(R.string.type_alcohol)
        }
        if (textoPrecoGasolina == "") {
            mainView.onError(R.string.type_gas)
        }
    }
}