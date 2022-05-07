package pt.ulusofona.cm.kotlin.observerobservable.models

import pt.ulusofona.cm.kotlin.observerobservable.interfaces.OnNumeroListener

class LeitorImpar(nome: String) : Leitor(nome), OnNumeroListener {
    private val numsImPar: ArrayList<Int> = ArrayList()

    override fun onReceiveNumero(num: Int) {
        numsImPar.add(num)
    }

    fun imprimeNumeros() : String{
        val numsStr : StringBuilder = StringBuilder()
        numsImPar.forEach { numsStr.append(it) }
        return "$nome leu os seguintes numeros pares: $numsStr"
    }
}