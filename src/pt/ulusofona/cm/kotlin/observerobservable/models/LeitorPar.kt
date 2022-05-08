package pt.ulusofona.cm.kotlin.observerobservable.models

import pt.ulusofona.cm.kotlin.observerobservable.interfaces.OnNumeroListener

class LeitorPar(nome:String): Leitor(nome), OnNumeroListener {
    private val numsPar: MutableList<Int> = mutableListOf()

    override fun onReceiveNumero(num: Int) {
        numsPar.add(num)
    }

    fun imprimeNumeros() : String{
        val numsStr : StringBuilder = StringBuilder()
        numsPar.forEach { numsStr.append(it) }
        return "$nome leu os seguintes numeros pares: $numsStr"
    }

}