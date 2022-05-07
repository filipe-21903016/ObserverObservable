package pt.ulusofona.cm.kotlin.observerobservable.models

import pt.ulusofona.cm.kotlin.observerobservable.interfaces.OnNumeroListener

class GeradorNumerico(
    val maxLeitores : Int,
    private val nums: ArrayList<Int> = ArrayList()
) {
    private val numListeners : ArrayList<OnNumeroListener> = ArrayList()

    fun adicionarLeitor(leitor : OnNumeroListener){}
    fun removerLeitor(leitor: OnNumeroListener){}
    private fun notificarLeitores(){}
    fun iniciar(){}
}