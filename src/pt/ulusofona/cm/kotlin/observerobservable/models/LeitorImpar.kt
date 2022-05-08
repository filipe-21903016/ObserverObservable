package pt.ulusofona.cm.kotlin.observerobservable.models

import pt.ulusofona.cm.kotlin.observerobservable.interfaces.OnNumeroListener

class LeitorImpar(nome: String = "LeitorImpar") : Leitor(nome), OnNumeroListener {
    val numeros: MutableList<Int> = mutableListOf()

    override fun onReceiveNumero(num: Int) {
        if (num % 2 != 0) numeros.add(num)
    }

    fun imprimeNumeros() : String{
        return "$nome leu os seguintes numeros impares: $numeros"
    }
}