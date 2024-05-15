package com.darleyleal.currencyconverter.viewmodel

import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    /**Os valores das moedas foram verificados na data 14/05/2024*/

    fun calcularDolar(valor: Float): Float {
        return valor * 5.13F
    }

    fun calcularEuro(valor: Float): Float {
        return valor * 5.54F
    }
}