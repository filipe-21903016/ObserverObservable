package pt.ulusofona.cm.kotlin.observerobservable.models

import pt.ulusofona.cm.kotlin.observerobservable.interfaces.OnNumeroListener

class GeradorNumerico(
    val maxLeitores : Int,
    private val nums: List<Int>
) {
    private val numListeners : List<OnNumeroListener> = listOf()

    fun adicionarLeitor(leitor : OnNumeroListener){}
    fun removerLeitor(leitor: OnNumeroListener){}
    private fun notificarLeitores(){}
    fun iniciar(){}
}